public class TesteHeranca {

    public static void main(String[] args) {
        
        System.out.println("--- Teste Pessoa ---");
        Pessoa p1 = new Pessoa("Ana Silva", "111.222.333-44", 30);
        p1.exibirDadosBasicos();

        System.out.println("\n--- Teste Funcionário ---");
        Funcionario f1 = new Funcionario("Bruno Costa", "222.333.444-55", 45, 4500.00, "Analista de Sistemas");
        f1.exibirDadosBasicos();
        System.out.printf("Salário Anual: R$ %.2f\n", f1.calcularSalarioAnual());

        System.out.println("\n--- Teste Gerente ---");
        Gerente g1 = new Gerente("Carla Dias", "333.444.555-66", 50, 12000.00, "Gerente de TI", "Tecnologia");
        g1.exibirDadosBasicos();
        System.out.printf("Salário Anual: R$ %.2f\n", g1.calcularSalarioAnual());
    }
}

class Pessoa {
    
    protected String nome;
    protected String cpf;
    protected int idade;

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public void exibirDadosBasicos() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Idade: " + this.idade);
    }
}

class Funcionario extends Pessoa {

    private double salario;
    private String cargo;

    public Funcionario(String nome, String cpf, int idade, double salario, String cargo) {
        super(nome, cpf, idade);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double calcularSalarioAnual() {
        return this.salario * 12;
    }
    
    public String getCargo() {
        return this.cargo;
    }
}

class Gerente extends Funcionario {
    
    private String departamento;

    public Gerente(String nome, String cpf, int idade, double salario, String cargo, String departamento) {
        super(nome, cpf, idade, salario, cargo);
        this.departamento = departamento;
    }

    @Override
    public void exibirDadosBasicos() {
        super.exibirDadosBasicos();
        System.out.println("Cargo: " + super.getCargo());
        System.out.println("Departamento: " + this.departamento);
    }
}