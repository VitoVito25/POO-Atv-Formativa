public class Financiamento {

    private double valorImovel;
    private double prazoFinanciamento; // Em anos
    private double taxaJurosAnual;
    

    public Financiamento(double valorImovel, double prazoFinanciamento, double taxaJurosAnual ) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double calcularPagamentoMensal() {
        double prazoFinanciamentoMeses = this.prazoFinanciamento * 12;
        double taxaJurosMensal = this.taxaJurosAnual / 12;
        double valorPagamentoMensal = this.valorImovel / prazoFinanciamentoMeses * (1 + taxaJurosMensal);

        return valorPagamentoMensal;
    }

    public double totalPagamento() {
        double valorPagamentoMensal = calcularPagamentoMensal();
        double prazoFinanciamentoMeses = this.prazoFinanciamento * 12;
        double valorTotalPagamento = prazoFinanciamentoMeses * valorPagamentoMensal;

        return valorTotalPagamento;
    }
}