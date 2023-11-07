import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        double [] _moexDelta = new double[21];
        double [] _endingYearCapital;
        /*_moexDelta[0] = 0;*/

        _moexDelta = MoexDelta();
        double _yearsAmount;
        int _yearsForCalc = 0;
        int _initialCapital = 1;
        float _getPercent = 0.05f;
        double _startYearCapital = _initialCapital - _getPercent; //первый стартовый капитал минус первый процент изъятия
        double _endYearCapital;

        System.out.println("Paste Year:");
        Scanner yearsInput = new Scanner(System.in);
        _yearsForCalc = yearsInput.nextInt();
        _yearsAmount = 2022 - _yearsForCalc;


        System.out.println("Начало : " + _startYearCapital);

        for (double i = _yearsForCalc; i < 2022; i++) {
             _endYearCapital = _startYearCapital + (_startYearCapital * _moexDelta[(int)(2022f - i)]);
            System.out.println("Конец : " + _endYearCapital);
             _startYearCapital = _endYearCapital - (_getPercent + Constances.INFLATION_RATE[(int)(2022f - i)]);
            System.out.println("Начало : " + _startYearCapital);


        }
    }

    //вычисление дельты мосБиржи
    public static double [] MoexDelta(){
        double [] moexDelta = new double[21];
        moexDelta[0] = 0;
        for (int i = 1; i < 21; i++) {
            moexDelta[i] = ((Constances.MOEX_RATE[i] - Constances.MOEX_RATE[i-1])/Constances.MOEX_RATE[i-1])*100;
        }
        return moexDelta;
    }
}