import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double [] _moexDelta = new double[21];
        double [] _endingYearCapital;

        _moexDelta = MoexDelta();
        int _yearsAmount;
        int _yearsForCalc = 0;
        int _initialCapital = 100;
        float _getPercent = 0f;
        double _startYearCapital = 100;//_initialCapital - _getPercent; //первый стартовый капитал минус первый процент изъятия
        double _endYearCapital = 0;



        System.out.println("Paste Year:");
        Scanner yearsInput = new Scanner(System.in);
        _yearsForCalc = yearsInput.nextInt();
        _yearsAmount = 2022 - _yearsForCalc;
        if (_yearsForCalc > 2021){
            return;
        }
        System.out.println ("Максимальный процент изъятия : " + GetPercentCalculations(_startYearCapital,_endYearCapital, _yearsAmount, _initialCapital, _getPercent, _yearsForCalc, MoexDelta()));

    }
   public static float GetPercentCalculations(double startYearCapital, double endYearCapital, int yearsAmount, int initialCapital, float getPercent,  int yearsForCalc, double[]moexDelta ){

        while (startYearCapital > 0) {
            int counter = (Constances.INFLATION_RATE.length - yearsAmount);
            startYearCapital = initialCapital - getPercent;
            endYearCapital = 0;

            for (int i = yearsForCalc; i < 2022; i++) {
                System.out.println(i + " - " + startYearCapital);
                endYearCapital = startYearCapital + (startYearCapital * moexDelta[counter]);
                startYearCapital = endYearCapital - (getPercent + (Constances.INFLATION_RATE[counter - 1]));
                counter++;
            }
                getPercent += 0.5f;
        }
        getPercent -= 1f;
        if(getPercent > 0){
            return getPercent;
        } else {
            return 0;
        }
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