package com.learn.string;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * <a href="https://www.hackerrank.com/challenges/morgan-and-a-string/problem />
 */
public class MorganAndString {

    public static String morganAndString(String next, String next2) {

        LinkedList<Character> nextStack = new LinkedList<>();
        LinkedList<Character> next2Stack = new LinkedList<>();

        for(Character c : next.toCharArray())
            nextStack.push(c);
        for(Character c: next2.toCharArray())
            next2Stack.push(c);

        return createLexographicalString(nextStack, next2Stack);


    }

    private static String createLexographicalString(LinkedList<Character> nextStack,
                                                    LinkedList<Character> next2Stack) {
        StringBuilder strBldr = new StringBuilder();

        while(!nextStack.isEmpty() && !next2Stack.isEmpty())
        {
            if(nextStack.getLast().equals(next2Stack.getLast()))
            {
                if( popLeft(nextStack, next2Stack))
                {
                    Character until = nextStack.getLast();

                    while(!nextStack.isEmpty() && nextStack.getLast().equals(until))
                        strBldr.append(nextStack.removeLast());

                }
                else
                {
                    Character until = next2Stack.getLast();

                    while(!next2Stack.isEmpty() && next2Stack.getLast().equals(until))
                        strBldr.append(next2Stack.removeLast());

                }
            }
            else
            if(nextStack.getLast() < next2Stack.getLast())
                strBldr.append(nextStack.removeLast());
            else
                strBldr.append(next2Stack.removeLast());
        }


        while(!nextStack.isEmpty())
            strBldr.append(nextStack.removeLast());
        while(!next2Stack.isEmpty())
            strBldr.append(next2Stack.removeLast());

        return strBldr.toString();
    }

    private static boolean popLeft(LinkedList<Character> nextStack, LinkedList<Character> next2Stack) {
        ListIterator<Character> lstItr = nextStack.listIterator(nextStack.size());
        ListIterator<Character> lstItr2 = next2Stack.listIterator(next2Stack.size());

        while(lstItr.hasPrevious() && lstItr2.hasPrevious())
        {
            Character left = lstItr.previous();
            Character right = lstItr2.previous();
            if(!left.equals(right)) {
                return (left < right);
            }
        }

        return lstItr.hasPrevious();

    }
}
