package Esercitazione5;

public class ContoRisparmio extends AbstractBankingAccount {
    private double saldo = 0.0;

    public ContoRisparmio(User proprietario) {
        super(proprietario);
    }

    @Override
    public boolean deposita(double val) {
        if (val < 0)
            throw new NegativeFund("Non è possibile depositare un importo negativo");

        this.saldo += val;
        System.out.println(val + "€ sono stati depositati!. Il tuo saldo è di €" + this.saldo);
        return true;
    }

    @Override
    public boolean preleva(double val) {
        if (val < 0)
            throw new NegativeFund("Non è possibile prelevare un importo negativo");

        if (val > this.saldo)
            throw new SaldoInsufficiente("L'importo che si sta tentando di prelevare è " +
                    "superiore al saldo disponibile");

        this.saldo -= val;
        System.out.println(val + "€ sono stati prelevati!. Il nuovo saldo è €" + this.saldo);
        return true;
    }

    @Override
    public double saldo() {
        return this.saldo;
    }

    @Override
    public int compareTo(BankOperations o) {
        return Double.compare(this.saldo, o.saldo());
    }
}
