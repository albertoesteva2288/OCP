package ch.diso.q04;

import java.util.Collections;
import java.util.Stack;

class Deck<T> {

    private Stack<T> objs;

    Deck() {
        objs = new Stack<T>();
    }

    public void add(T obj) {
        objs.add(obj);
    }

    public T draw() {
        if (!objs.empty()) return objs.pop();
        else return null;
    }

    public void shuffle() {
        Collections.shuffle(objs);
    }
}