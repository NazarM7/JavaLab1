
import java.util.Scanner;
    /** Програма виводить на екран парні за спаданням і непарні за зростанням числа з інтервалу(які вводить користувач)
     * і будує ряд Фібоначчі
     * @author Yura */
    public class Main {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Main obj = new Main();
            Interval inobj = new Interval();
            Fibonacci fibobj = new Fibonacci();
            System.out.println("Введіть початок інтервалу:");
            int x_ = in.nextInt();
            inobj.Set_x(x_);
            System.out.println("Введіть кінець інтервалу:");
            int y_ = in.nextInt();
            inobj.Set_y(y_);
            System.out.println("Ваш інтервал [" + inobj.Get_x() + ";" + inobj.Get_y() + "]");
            inobj.Out_Numb();
            System.out.print("Сума непарних чисел: " + inobj.Get_odd_sum()+"\n");
            System.out.println("Сума парних чисел: " + inobj.Get_even_sum());
            System.out.println();
            System.out.println("Введіть довжину ряду Фібоначчі");
            int length_fib_ = in.nextInt();
            fibobj.Set_length(length_fib_);
            fibobj.Fibonacci(inobj.Get_x(), inobj.Get_y());
            fibobj.Percentage_Out();
        }
    }

    class Interval{

        /** Поле - Початок інтервалу */
        private int x;
        /** Поле - кінець інтервалу */
        private int y;
        private int sum_odd;
        private int sum_even;

        void Set_x (int x_) { x= x_; }
        void Set_y (int y_) { y= y_; }

        int Get_x(){return x;}
        int Get_y(){return y;}
        int Get_odd_sum() {return sum_odd;}
        int Get_even_sum() {return sum_even;}

        /**
         * Метод Out_Numb() Виводить числа з інтегралу
         */

        void Out_Numb(){
            sum_odd = 0;
            for(int i = x; i < y; i++){  // Цикл для виведення непарних чисел у порядку зростання
                if((i%2) != 0) {
                    sum_odd = sum_odd + i;
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            System.out.println();
            for(int i = y; i > x; i--) {  // Цикл для виведення парних чисел у порядку спадання
                if ((i % 2) == 0) {
                    sum_even = sum_even + i;
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

    }

    class Fibonacci{

        /** Поле - довжина ряду Фібоначчі*/
        private int length_fib;
        private int second_num;
        private int first_num;
        private int even_numb = 1;
        private int odd_numb = 1;

        void Set_length(int length_){ length_fib =length_; }

        /**
         * Метод  Fibonacci() будує ряд Фібоначчі, де першим числом є найбільше непарне і друге парне,
         * довжину ряду вводить користувач
         */
        void Fibonacci(int x , int y){
            if((y % 2)!= 0) {
                first_num = y;
                second_num = y - 1;
            }
            else{
                second_num = y;
                first_num = y - 1;
            }
            int n;
            System.out.print(first_num+" "+second_num+" ");
            for(int i = 3; i <= length_fib; i++){  // Цикл для генерування ряду Фібоначчі
                n=first_num+second_num;
                System.out.print(n+" ");
                first_num=second_num;
                second_num=n;
                if((n%2) == 0 )
                    even_numb++;
                else
                    odd_numb++;
            }
        }

        /**
         * Метод  Percentage_Out() виводить відсотки на екран
         */
        void Percentage_Out(){
            System.out.println();
            System.out.println("Відсоток парних чисел з ряду Фібоначчі: " + Percentage(even_numb, length_fib) + "%");
            System.out.println("Відсоток непарних чисел з ряду Фібоначчі: " + Percentage(odd_numb, length_fib) + "%");
            System.out.println();
        }

        /**
         * Метод Percentage () Виводить відсоток парних і непарних чисел
         * @return повернення відсотку чисел
         */
        double Percentage(int numb, int length_fib){
            return numb * 100/length_fib;
        }
    }


