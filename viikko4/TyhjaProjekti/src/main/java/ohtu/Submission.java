package ohtu;

public class Submission {

    private String student_number;
    private int week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int doneTasksSum() {
        int luku = 0;
        if (a1 == true) {
            luku++;
        }
        if (a2 == true) {
            luku++;
        }
        if (a3 == true) {
            luku++;
        }
        if (a4 == true) {
            luku++;
        }
        if (a5 == true) {
            luku++;
        }
        if (a6 == true) {
            luku++;
        }
        if (a7 == true) {
            luku++;
        }
        if (a8 == true) {
            luku++;
        }
        if (a9 == true) {
            luku++;
        }
        if (a10 == true) {
            luku++;
        }
        if (a11 == true) {
            luku++;
        }
        if (a12 == true) {
            luku++;
        }
        if (a13 == true) {
            luku++;
        }
        if (a14 == true) {
            luku++;
        }
        if (a15 == true) {
            luku++;
        }
        if (a16 == true) {
            luku++;
        }
        if (a17 == true) {
            luku++;
        }
        if (a18 == true) {
            luku++;
        }
        if (a19 == true) {
            luku++;
        }
        if (a20 == true) {
            luku++;
        }
        if (a21 == true) {
            luku++;
        }
        return luku;
    }

    public String TasksThatAreDone() {
        String tasks = "";
        if (a1 == true) {
            tasks = tasks + " 1";
        }
        if (a2 == true) {
            tasks = tasks + " 2";
        }
        if (a3 == true) {
            tasks = tasks + " 3";
        }
        if (a4 == true) {
            tasks = tasks + " 4";
        }
        if (a5 == true) {
            tasks = tasks + " 5";
        }
        if (a6 == true) {
            tasks = tasks + " 6";
        }
        if (a7 == true) {
            tasks = tasks + " 7";
        }
        if (a8 == true) {
            tasks = tasks + " 8";
        }
        if (a9 == true) {
            tasks = tasks + " 9";
        }
        if (a10 == true) {
            tasks = tasks + " 10";
        }
        if (a11 == true) {
            tasks = tasks + " 11";
        }
        if (a12 == true) {
            tasks = tasks + " 12";
        }
        if (a13 == true) {
            tasks = tasks + " 13";
        }
        if (a14 == true) {
            tasks = tasks + " 14";
        }
        if (a15 == true) {
            tasks = tasks + " 15";
        }
        if (a16 == true) {
            tasks = tasks + " 16";
        }
        if (a17 == true) {
            tasks = tasks + " 17";
        }
        if (a18 == true) {
            tasks = tasks + " 18";
        }
        if (a19 == true) {
            tasks = tasks + " 19";
        }
        if (a20 == true) {
            tasks = tasks + " 20";
        }
        if (a21 == true) {
            tasks = tasks + " 21";
        }
        return tasks;
    }

    @Override
    public String toString() {
        return "viikko " + getWeek() + ": tehtyjä tehtäviä yhteensä: " + doneTasksSum() +
                ", aikaa kului " + getHours() + " tuntia, tehdyt tehtävät:" + TasksThatAreDone();
    }

}
