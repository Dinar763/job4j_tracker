package ru.job4j.hasmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0D;
        int counterSubjects = 0;
        for (Pupil pupil: pupils) {
            for (Subject subject: pupil.subjects()) {
                sumScore += subject.score();
                counterSubjects++;
            }
        }
        return counterSubjects == 0 ? 0D : sumScore / counterSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> listOfLabel = new ArrayList<>();
        double sumScore = 0D;
        int counterSubjects = 0;
        for (Pupil pupil: pupils) {
            for (Subject subject: pupil.subjects()) {
                sumScore += subject.score();
                counterSubjects++;
            }
            listOfLabel.add(new Label(pupil.name(), sumScore / counterSubjects));
            sumScore = 0;
            counterSubjects = 0;
        }
        return listOfLabel;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> setOfName = new HashSet<>();
        for (Pupil pupil: pupils) {
            for (Subject subject: pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
            setOfName.add(pupil.name());
        }
        List<Label> listOfLabel = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            listOfLabel.add(new Label(entry.getKey(), entry.getValue() / (double) setOfName.size()));
        }
        return listOfLabel;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> listOfLabel = new ArrayList<>();
        double sumScore = 0D;
        for (Pupil pupil: pupils) {
            for (Subject subject: pupil.subjects()) {
                sumScore += subject.score();
            }
            listOfLabel.add(new Label(pupil.name(), sumScore));
            sumScore = 0;
        }
        listOfLabel.sort(Comparator.naturalOrder());
        return listOfLabel.get(listOfLabel.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new HashMap<>();
        for (Pupil pupil: pupils) {
            for (Subject subject: pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> listOfLabel = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            listOfLabel.add(new Label(entry.getKey(), entry.getValue()));
        }
        listOfLabel.sort(Comparator.naturalOrder());
        return listOfLabel.get(listOfLabel.size() - 1);
    }

    public static void main(String[] args) {
        List<Label> average = AnalyzeByMap.averageScoreByPupil(
            List.of(
                new Pupil("Ivanov",
                    List.of(
                        new Subject("Math", 100),
                        new Subject("Lang", 60),
                        new Subject("Philosophy", 80)
                    )
                ),
                new Pupil("Petrov",
                    List.of(
                        new Subject("Math", 80),
                        new Subject("Lang", 90),
                        new Subject("Philosophy", 70)
                    )
                ),
                new Pupil("Sidorov",
                    List.of(
                        new Subject("Math", 70),
                        new Subject("Lang", 60),
                        new Subject("Philosophy", 50)
                    )
                )
            )
        );
        System.out.println(average.size());
    }
}
