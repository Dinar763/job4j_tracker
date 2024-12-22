package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу главного сервиса банковского приложения
 * @author Dinar Gizzyatov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей с прикрепленными к ним счетами
     * осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавление пользователя в хранилище
     * @param user пользователь, который добавляется в хранение
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаление пользователя из хранения
     * @param passport, паспорт пользователя которого необходимо удалить из хранения
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавления пользователю нового счета
     * @param passport, паспорт по которому происходит идентификация пользователя
     * @param account, реквизиты счета который необходимо добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = getAccounts(findByPassport(passport));
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод поиска пользователя по паспорту
     * @param passport, паспорт по которому происходит поиск в системе хранения
     * @return возвращает либо найденного пользователя, если он есть в системе,
     * либо null если пользователя нет в системе
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User key: users.keySet()) {
            if (key.getPassport().equals(passport)) {
                user = key;
                break;
            }
        }
        return user;
    }

    /**
     * Метод осуществляет поиск счета у пользователя
     * @param passport, паспорт по которому происходит поиск в системе хранения
     * @param requisite, реквизиты счета по которым происходит поиск в системе хранения
     * @return возвращает реквизиты счета, если такой счет есть в системе,
     * либо возвращает null при отсутствии ревизитов счета
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account valueAcc: accountList) {
                if (valueAcc.getRequisite().equals(requisite)) {
                    account = valueAcc;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Метод осуществляет перевод денег между счетами отправителя и получателя,
     * если у отправителя есть денежные средства - с его счета деньги списываются, а получателю добавляются
     * @param sourcePassport, паспорт отправителя
     * @param sourceRequisite, реквизиты счета отправителя
     * @param destinationPassport, паспорт получателя
     * @param destinationRequisite, реквизиты счета получателя
     * @param amount, сумма денежных средств для перевода
     * @return, возвращает булево значение - перевод осуществлен, либо нет.
     * Если счёт не найден или не хватает денег на счёте sourcePassport (с которого переводят),
     * то метод должен вернуть false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод получения списка счетов у пользователя
     * @param user, пользователь у которого необходимо получить список счетов
     * @return, возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
