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
        int queueIndex;
        BasicLinkedListClass queueData = new BasicLinkedListClass();

        for(queueIndex = 0; queueIndex <
                queueData.getCurrentSize();queueIndex++)
        {
            queueData.setAtIndex(queueIndex,
                    copied.queueData.getAtIndex(queueIndex),
                    BasicLinkedListClass.REPLACE);
        }
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
            System.out.print(queueData.getAtIndex(queueIndex) + ", ");
        }
    }

    public void enqueue(int newValue)
    {
        queueData.setAtIndex(0,newValue,
                BasicLinkedListClass.INSERT_BEFORE);
    }

    public int dequeue()
    {
        return queueData.removeAtIndex(0);
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
