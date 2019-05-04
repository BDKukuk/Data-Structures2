package p6_package;

import p5_package.BasicArrayClass;

public class QueueClass
{
    private BasicLinkedListClass queueData;

    QueueClass()
    {
        BasicLinkedListClass queueData = new BasicLinkedListClass();
    }

    QueueClass(QueueClass copied)
    {
        BasicLinkedListClass queueData = new BasicLinkedListClass(copied.queueData);
    }

    public void clear()
    {
        queueData.clear();
    }

    public void displayQueue()
    {
        int queueIndex = 0;

        while(queueIndex < queueData.getCurrentSize())
        {
            System.out.print("Head -->");
            System.out.printf(queueData.getAtIndex(queueIndex) + ", ");
            System.out.print("<-- Tail");
        }
    }

    public void enqueue(int newValue)
    {
        queueData.setAtIndex(0,newValue,
                BasicLinkedListClass.INSERT_BEFORE);
    }

    public int dequeue()
    {
        return queueData.removeAtIndex(queueData.getCurrentSize() -1);
    }

    public boolean isEmpty()
    {
        return queueData.isEmpty();
    }

    public int peekFront()
    {
        return queueData.getAtIndex(queueData.getCurrentSize());
    }
}
