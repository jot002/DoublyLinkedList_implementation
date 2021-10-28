/*
 * NAME: Jonathan Tran
 * PID: A15967290
 */

/**
 * RounndRobin is created to move tasks from a waitlist to a finished list
 * based on the quantum, burst times, and wait times.
 *
 * @author Jonathan Tran
 * @since 10/27/2021
 */
public class RoundRobin {

    /* constants */
    private static final String TASK_HANDLED = "All tasks are already handled.";

    /* instance variables */
    private DoublyLinkedList<Task> waitlist, finished;
    private int quantum, burstTime, waitTime;

    /**
     * This constructor uses the constructor and sets quantum to 4.
     * @param toHandle is an array of tasks that have to be handled
     */
    public RoundRobin(Task[] toHandle) {
        this(4, toHandle);
    }

    /**
     * This constructor assigns waitlist to a doubly link list that
     * contains the tasks that have to be completed, finished to a
     * doubly linked list, quantum to 0, and burstTime and waitTime to 0.
     * @param quantum an int that represents the time unit
     * @param toHandle is an array of tasks that have to be handled
     */
    public RoundRobin(int quantum, Task[] toHandle) {
        if (quantum < 1) {
            throw new IllegalArgumentException();
        }
        if (toHandle == null) {
            throw new IllegalArgumentException();
        }
        if (toHandle.length == 0) {
            throw new IllegalArgumentException();
        }
        this.quantum = quantum;
        this.burstTime = 0;
        this.waitTime = 0;
        this.finished = new DoublyLinkedList<Task>();
        this.waitlist = new DoublyLinkedList<Task>();
        for (int i = 0; i < toHandle.length; i++) {
            this.waitlist.add(toHandle[i]);
        }
    }

    /**
     * This method handles all the tasks that are put in. It goes through the
     * waitlist and goes through each task with a certain time, and moves on.
     * If the task is not done, it is put back into the waitlist, but if it
     * is done, it will be put into finished, a doubly linked list that
     * represents the tasks that are finished.
     * @return String that contains the details of how long the tasks took
     * using burstTime and waitTime, and showing the order of the tasks that
     * finished.
     */
    public String handleAllTasks() {
        Task firstTask;
        if (waitlist.size() == 0) {
            return TASK_HANDLED;
        }
        else {
            while (this.waitlist.size() > 0) {
                for (int i = 0; i < this.quantum; i++) {
                    firstTask = this.waitlist.get(0);
                    // increases waitTime by the amount of tasks waiting
                    this.waitTime = this.waitTime + (this.waitlist.size() - 1);
                    this.burstTime++;
                    firstTask.handleTask();
                    // breaks if the firstTask is done
                    if (firstTask.isFinished() == true) {
                        break;
                    }
                }
                firstTask = this.waitlist.get(0);
                if (firstTask.isFinished() == false) {
                    // adds the task to end of the waitlist
                    // removes it from the beginning of the waitlist
                    this.waitlist.add(firstTask);
                    this.waitlist.remove(0);
                }
                else {
                    // adds the task to finished and removes it from waitlist
                    this.finished.add(firstTask);
                    this.waitlist.remove(0);
                }
            }
        }
        String sentence = String.format("All tasks are handled within %d " +
                "units of burst time and %d units of wait time. The tasks " +
                "are finished in this order:\n", burstTime, waitTime);
        // adds each task to the sentence
        for (Task task : this.finished) {
            sentence = sentence + task.toString();
            // adds an arrow if the task is not last
            if (task != this.finished.get(this.finished.size()-1)) {
                sentence = sentence + " -> ";
            }
        }
        return sentence;
    }

    /**
     * Main method for testing.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Task[] test1 = {new Task("A", 3), new Task("B", 4),
                        new Task("C", 4), new Task("D", 12),
                        new Task("E", 6), new Task("F", 3)};
        RoundRobin rr1 = new RoundRobin(3, test1);     // Quantum: 3, ToHandle: test1
        System.out.println(rr1.handleAllTasks());   // Burst: 32, Wait: 86, Order: AFBCED
        System.out.println();
        System.out.println(rr1.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test2 = {new Task("A", 9), new Task("B", 8),
                        new Task("C", 6), new Task("D", 4),
                        new Task("E", 4), new Task("F", 3)};
        RoundRobin rr2 = new RoundRobin(test2);  // Quantum: 4, ToHandle: test2
        System.out.println(rr2.handleAllTasks());   // Burst: 34, Wait: 123, Order: DEFBCA
        System.out.println();
        System.out.println(rr2.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test3 = {new Task("A", 7), new Task("B", 5),
                        new Task("C", 3), new Task("D", 1),
                        new Task("E", 2), new Task("F", 4),
                        new Task("G", 6), new Task("H", 8)};
        RoundRobin rr3 = new RoundRobin(3, test3);     // Quantum: 3, ToHandle: test3
        System.out.println(rr3.handleAllTasks());   // Burst: 36, Wait: 148, Order: CDEBFGAH
        System.out.println();
        System.out.println(rr3.handleAllTasks());   // TASK_HANDLED
        System.out.println();
    }
}
