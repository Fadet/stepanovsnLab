package tech.reliab.course.stepanovsnLab.bank.service;

import tech.reliab.course.stepanovsnLab.bank.entity.BankAtm;
import tech.reliab.course.stepanovsnLab.bank.model.BankAtmRequest;

import java.util.List;

public interface BankAtmService {
    void requestBankInfo();

    BankAtm createBankAtm(BankAtmRequest bankAtmRequest);

    void deleteBankAtm(int id);

    BankAtm updateBankAtm(int id, String name);

    BankAtm getBankAtmDtoById(int id);

    List<BankAtm> getAllBankAtmsByBankId(int bankId);

    List<BankAtm> getAllBankAtms();
}
