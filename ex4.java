package EstruturaDeDados;

import javax.swing.JOptionPane;

public class ex4 {
//ENZO HIDEKI YOSHIDA 2022102000641
	public static void main(String[] args) {

        int mesas = 0;
        int numDaMesa = 1;
        int lugares;
        boolean disponibilidade = true;
        int lugaresDisponveis = 0;
        int auxLugar = 0;
        int auxRecebeNumDaMesa = 0;
        boolean flag = false;

        //número de mesas para escolher
        while (mesas < 50 || mesas > 200) {
            mesas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de mesas para reservar(Mín:50, Máx:200): "));
            if(mesas<50){
                JOptionPane.showMessageDialog(null, "Número inválido, menos de 50 mesas reservadas");
            }if(mesas>200){
                JOptionPane.showMessageDialog(null, "Número inválido, mais de 200 mesas reservadas");
            }if(mesas<50 || mesas>200){
                mesas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de mesas para reservar(Mín:50, Máx:200): "));
            }
        }
        //número de mesas reservadas
        JOptionPane.showMessageDialog(null, "Número de mesas reservadas: " + mesas);

        //armazenar número de mesas reservadas em um vetor
        int vetorMesas[] = new int[mesas];
        //aviso
        JOptionPane.showMessageDialog(null, "Cada mesa tem 6 cadeiras disponíveis");
        //escolher o número da mesa para reservar os lugares
        while(numDaMesa != -1){
            flag = false;
            numDaMesa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da mesa para reservar (0 para SAIR): "));
            numDaMesa--;
            while(disponibilidade == false || numDaMesa <0 || numDaMesa > 200){
                if(numDaMesa == -1){
                    JOptionPane.showMessageDialog(null, "Você digitou 0, para SAIR do programa");
                    System.exit(0);
                }
                numDaMesa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da mesa para reservar (0 para SAIR): "));
                disponibilidade = true;
                flag = false;
                numDaMesa--;
            }

            //número de cadeiras por mesa disponíveis
            lugares = Integer.parseInt(JOptionPane.showInputDialog("Escolha quantos lugares da mesa "+(numDaMesa+1) +" deseja reservar: "));

            //verificar se os lugares foram reservados
            if(vetorMesas[numDaMesa] == 6){
                auxRecebeNumDaMesa = vetorMesas[numDaMesa];//auxiliar para guardar a quantidade de lugares reservados
                JOptionPane.showMessageDialog(null, "Mesa "+(numDaMesa+1)+" já tem "+auxRecebeNumDaMesa+" ou mais lugares reservados. Selecione outra mesa para reservar, por favor");
                disponibilidade = false;
            }
            //verificar mesas com lugares disponiveis
            if(vetorMesas[numDaMesa] == 5 || vetorMesas[numDaMesa] == 4 || vetorMesas[numDaMesa] == 3 || vetorMesas[numDaMesa] == 2 || vetorMesas[numDaMesa] == 1){
                auxRecebeNumDaMesa = vetorMesas[numDaMesa];//auxiliar para guardar a quantidade de lugares reservados
                JOptionPane.showMessageDialog(null, "Mesa "+(numDaMesa+1)+" já tem "+auxRecebeNumDaMesa+" lugares reservados, necessário atualizar valor");
                lugares = Integer.parseInt(JOptionPane.showInputDialog(null, "Atualize a quantidade de reservas da mesa " +(numDaMesa+1) +" com um novo valor: "));
                vetorMesas[numDaMesa] = lugares;
                auxLugar += (lugares - auxRecebeNumDaMesa); //auxiliar para atualizar o valor de lugares reservados
                JOptionPane.showMessageDialog(null, "Reserva atualizada com sucesso " +lugares +" lugares da " +(numDaMesa+1));
                flag = true;
            }
            //reservar a mesa disponível
            if(disponibilidade == true && lugares > 0 && lugares <= 6 && flag != true){
                JOptionPane.showMessageDialog(null, "Reservado com sucesso " +lugares +" lugares da " +(numDaMesa+1));
                vetorMesas[numDaMesa] = lugares;
                auxLugar += lugares; //auxiliar pra somar os numeros de lugares ja reservados
            }
            
            //verificar valor dos lugares
            while(lugares > 6 || lugares <= 0){
                if(lugares>6){
                    JOptionPane.showMessageDialog(null, "Número inválido, mais de 6 cadeiras na mesa: " +(numDaMesa+1));
                    lugares = Integer.parseInt(JOptionPane.showInputDialog("Escolha quantos lugares da mesa " +(numDaMesa+1) +" deseja reservar: "));
                }
                if(lugares<=0){
                    JOptionPane.showMessageDialog(null, "Número inválido, você tentou selecionar 0 ou menos lugares na mesa: " +(numDaMesa+1));
                    lugares = Integer.parseInt(JOptionPane.showInputDialog("Escolha quantos lugares da mesa " +(numDaMesa+1) +" deseja reservar: "));
                }
            }
            //número de lugares reservados
            lugaresDisponveis = mesas*6-auxLugar; //numero de lugares ainda disponiveis
            JOptionPane.showMessageDialog(null, "Número de lugares reservados: " + lugares +" ainda disponíveis " + (lugaresDisponveis) +" lugares");

            //condição: todos os lugares reservados - encerrar
            if(lugaresDisponveis==0){
                JOptionPane.showMessageDialog(null, "Todas as cadeiras estão reservadas");
                System.exit(0);
            }

            //mostrar mesas e lugares no terminal
            JOptionPane.showMessageDialog(null, "Verifique no terminal todas as mesas e respectivas disponibilidades");
            for(int j = 0; j < mesas; j++){
                System.out.println("Mesa " +(j+1) + " com " + vetorMesas[j] + " lugares reservados");
            }
        }

    }
}