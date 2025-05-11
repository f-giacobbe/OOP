package Esercitazione5;

public abstract class AbstractBankingAccount implements BankOperations {
    private User proprietario;

    public AbstractBankingAccount(User proprietario) {
        this.proprietario = proprietario;
    }

    public User getProprietario() {
        return this.proprietario;
    }
}
