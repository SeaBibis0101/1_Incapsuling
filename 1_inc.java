// Пример инкапсуляции
// Класс описывает объект «банковский счёт».
class BankAccount {
    // Данные объекта скрыты от прямого доступа извне
    private String owner;
    private double balance;

    // Конструктор создаёт объект и задаёт его начальное состояние
    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;

        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Геттеры позволяют безопасно прочитать данные объекта
    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    // Сеттер изменяет данные только после проверки нового значения
    public void setOwner(String owner) {
        if (owner != null && !owner.trim().isEmpty()) {
            this.owner = owner;
        }
    }

    // Деньги изменяются только через специальные методы объекта
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Создание объекта счёта с владельцем и начальным балансом
        BankAccount account = new BankAccount("Ivan", 1000);

        // Вызов методов объекта для изменения его баланса
        account.deposit(500);
        account.withdraw(300);

        // Получение состояния объекта через геттеры
        System.out.println("Владелец: " + account.getOwner());
        System.out.println("Баланс: " + account.getBalance());

        // Прямой доступ account.balance запрещён — поле private
    }
}
