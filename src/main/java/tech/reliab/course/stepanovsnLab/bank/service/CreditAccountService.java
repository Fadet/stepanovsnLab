package tech.reliab.course.stepanovsnLab.bank.service;

import tech.reliab.course.stepanovsnLab.bank.entity.CreditAccount;
import tech.reliab.course.stepanovsnLab.bank.model.CreditAccountRequest;

import java.util.List;

public interface CreditAccountService {
    CreditAccount createCreditAccount(CreditAccountRequest creditAccountRequest);

    void deleteCreditAccount(int id);

    CreditAccount updateCreditAccount(int id, int bankId);

    CreditAccount getCreditAccountDtoById(int id);

    List<CreditAccount> getAllCreditAccounts();
}
