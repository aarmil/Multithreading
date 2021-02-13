public class HomeworkMain {

    static boolean isEqual = false;

    public static void main(String[] args) {
        int random = (int) (Math.random() * 1000000001);
        System.out.println(random);

        //Timer that stops when second thread guesses 'random' correctly
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                    int i = 0;
                try {
                    while (!isEqual) {
                        System.out.println(i);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                }
            }
        });
        timer.start();

        //Thread guessing the random number. When it guesses 'random' variable it stops and shows it
        Thread guess = new Thread(new Runnable() {
            @Override
            public void run() {
                    while (!isEqual) {
                        int anotherGuess = (int) (Math.random() * 1000000001);
                        if (anotherGuess == random) {
                            isEqual = true;
                            System.out.println(anotherGuess);
                        }
                    }
            }
        });
        guess.start();
    }
}
