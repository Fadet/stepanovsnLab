package tech.reliab.course.stepanovsnLab.bank;

import lombok.Getter;
import tech.reliab.course.stepanovsnLab.bank.repository.*;
import tech.reliab.course.stepanovsnLab.bank.repository.example.*;
import tech.reliab.course.stepanovsnLab.bank.service.BankAtmService;
import tech.reliab.course.stepanovsnLab.bank.service.UserService;
import tech.reliab.course.stepanovsnLab.bank.service.example.ExampleBankAtmService;
import tech.reliab.course.stepanovsnLab.bank.service.example.ExampleUserService;

import java.io.IOException;
import java.util.Scanner;

public class stepanovsnLabApplication {
    private static final UserRepository userRepository = new ExampleUserRepository();
    private static final BankRepository bankRepository = new ExampleBankRepository(userRepository);
    private static final BankOfficeRepository bankOfficeRepository = new ExampleBankOfficeRepository(bankRepository);
    private static final EmployeeRepository employeeRepository = new ExampleEmployeeRepository(bankRepository);
    private static final BankAtmRepository bankAtmRepository = new ExampleBankAtmRepository(bankRepository);
    private static final PaymentAccountRepository paymentAccountRepository = new ExamplePaymentAccountRepository(userRepository, bankRepository);
    private static final CreditAccountRepository creditAccountRepository = new ExampleCreditAccountRepository(userRepository);

    private static final BankAtmService bankAtmService = new ExampleBankAtmService(
            userRepository,
            bankRepository,
            bankOfficeRepository,
            employeeRepository,
            bankAtmRepository,
            paymentAccountRepository,
            creditAccountRepository
    );
    private static final UserService userService = new ExampleUserService(
            userRepository,
            creditAccountRepository,
            paymentAccountRepository
    );

    private static MenuOption menuOption;

    public static void main(String[] args) throws IOException {
        bankAtmService.initializeBanks();

        System.out.println(bankRepository.getAllBanks());
        while (SelectMenuOption()) {
            switch (menuOption) {
                case BANK_INFO:
                    bankAtmService.requestBankInfo();
                    break;
                case USER_INFO:
                    userService.requestUserInfo();
                    break;
            }

        }
    }

    private static boolean SelectMenuOption() {
        var scanner = new Scanner(System.in);
        System.out.println("Выберите действие:");
        System.out.println("1. Вывести информацию о банке");
        System.out.println("2. Вывести информацию о пользователе");
        System.out.println("3. Выйти");
        menuOption = MenuOption.valueOf(scanner.nextInt());
        return menuOption != MenuOption.EXIT;
    }

    @Getter
    static enum MenuOption {
        BANK_INFO(1),
        USER_INFO(2),
        EXIT(3);

        private final int value;

        MenuOption(int value) {
            this.value = value;
        }

        public static MenuOption valueOf(int value) {
            for (MenuOption menuOption : values()) {
                if (menuOption.value == value) {
                    return menuOption;
                }
            }
            throw new IllegalArgumentException("No such option");
        }
    }
}
