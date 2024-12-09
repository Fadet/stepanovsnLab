package tech.reliab.course.stepanovsnLab.bank.service;

import tech.reliab.course.stepanovsnLab.bank.entity.PaymentAccount;
import tech.reliab.course.stepanovsnLab.bank.model.PaymentAccountRequest;

import java.util.List;

public interface PaymentAccountService {
    PaymentAccount createPaymentAccount(PaymentAccountRequest paymentAccountRequest);

    void deletePaymentAccount(int id);

    PaymentAccount updatePaymentAccount(int id, int bankId);

    PaymentAccount getPaymentAccountDtoById(int id);

    List<PaymentAccount> getAllPaymentAccounts();
}
