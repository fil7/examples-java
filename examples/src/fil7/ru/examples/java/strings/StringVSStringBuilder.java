package fil7.ru.examples.java.strings;

import java.util.Date;

/**
 * Сравнение String с StringBuilder
 */
public class StringVSStringBuilder {

    public static void main(String[] args) {

        String [] charsArray = {"Q","W","E","R","T","Y","U","I","O",
                "P","A","S","D","F","G","H","J","K",
                "L","Z","X","C","V","B","N","M" };

        int charsArrayLength = charsArray.length - 1;
        int charsIterator = 0;

        String destString = "";
        StringBuilder destStringBuilder = new StringBuilder("");

        Timer timer = new Timer();

        System.out.println("Test String concatenate..");

        timer.start();

        for (int i=0; i<100000; i++)
        {
            destString += charsArray[charsIterator];
            if (++charsIterator>charsArrayLength) charsIterator=0;
        }

        timer.stop();

        System.out.println("Length of destString: "+destString.length());
        System.out.println("Time: "+timer.getWorkTimeInMS()+" ms");

        System.out.println("-----------------------------");

        System.out.println("Test StringBuilder concatenate..");

        charsIterator = 0;

        timer.start();

        for (int i=0; i<100000; i++)
        {
            destStringBuilder.append(charsArray[charsIterator]);
            if (++charsIterator>charsArrayLength) charsIterator=0;
        }

        timer.stop();

        System.out.println("Length of StringBuilder: "+destStringBuilder.length());
        System.out.println("Time: "+timer.getWorkTimeInMS()+" ms");

    }

    private static class Timer {

        private long start;
        private long end;

        private long getCurrentTimeInMS() {
            return new Date().getTime();
        }

        private void reset() {
            start = end = 0;
        }

        public void start() {
            reset();
            start = getCurrentTimeInMS();
        }

        public void stop() {
            end = getCurrentTimeInMS();
        }
        public long getWorkTimeInMS() {
            return end - start;
        }
    }
}
