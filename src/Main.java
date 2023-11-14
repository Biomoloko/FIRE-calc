import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        double [] _moexDelta = new double[21];
        double [] _endingYearCapital;
        /*_moexDelta[0] = 0;*/

        _moexDelta = MoexDelta();
        int _yearsAmount;
        int _yearsForCalc = 0;
        int _initialCapital = 100;
        float _getPercent = 10f;
        double _startYearCapital = _initialCapital - _getPercent; //первый стартовый капитал минус первый процент изъятия
        double _endYearCapital = 100;
        boolean enough = false;



        System.out.println("Paste Year:");
        Scanner yearsInput = new Scanner(System.in);
        _yearsForCalc = yearsInput.nextInt();
        _yearsAmount = 2022 - _yearsForCalc;
        int _iterations = (Constances.INFLATION_RATE.length - _yearsAmount);

        System.out.println(" Начало " + _yearsForCalc + " : " + _startYearCapital);
    while(_startYearCapital > 0) {
            int counter = _iterations;
        for (int i = _yearsForCalc; i < 2021; i++) {
                _endYearCapital = _startYearCapital + (_startYearCapital * _moexDelta[counter]);
                System.out.println("         Конец " + i + " : " + _endYearCapital);
                _startYearCapital = _endYearCapital - (_getPercent + (Constances.INFLATION_RATE[counter-1]));
                System.out.println(" Начало " + (i + 1) + " : " + _startYearCapital);
            counter++;
        }
        _getPercent += 0.5;
        System.out.println(_getPercent);
    }
    _getPercent -= 0.5;
        System.out.println(_getPercent);
    }

    //вычисление дельты мосБиржи
    public static double [] MoexDelta(){
        double [] moexDelta = new double[21];
        moexDelta[0] = 0;
        for (int i = 1; i < 21; i++) {
            moexDelta[i] = ((Constances.MOEX_RATE[i] - Constances.MOEX_RATE[i-1])/Constances.MOEX_RATE[i-1]);
        }
        return moexDelta;
    }
}