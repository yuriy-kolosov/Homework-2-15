package pro.sky.homework215.service;

import pro.sky.homework215.exception.InvalidIndexException;
import pro.sky.homework215.exception.InvalidStringListException;
import pro.sky.homework215.exception.NoStringException;
import pro.sky.homework215.exception.NoStringListException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] stringList;

    private int stringListBusy;

    public StringListImpl() {
        this.stringList = new String[4];
        this.stringListBusy = 0;
    }

    public int length() {
        return stringList.length;
    }

    public int size() {
        return stringListBusy;
    }

    @Override
    public String add(String item) {
        int newSize = stringList.length;
        if (item == null) {
            throw new NoStringException("Исходная строка отсутствует");
        } else if (stringListBusy == stringList.length - 1) {
            newSize *= 2;
            String[] stringListTemp = new String[newSize];
            System.arraycopy(stringList, 0, stringListTemp, 0, stringList.length);
            stringList = stringListTemp;
        }
        stringList[stringListBusy] = item;
        stringListBusy++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        int newSize = stringList.length;
        if (item == null) {
            throw new NoStringException("Исходная строка отсутствует");
        } else if (index >= stringListBusy) {
            throw new InvalidIndexException("Неверный индекс");
        } else if (stringListBusy == stringList.length - 1) {
            newSize *= 2;
        }
        String[] stringListTemp = new String[newSize];
        System.arraycopy(stringList, 0, stringListTemp, 0, index);
        System.arraycopy(stringList, index, stringListTemp, 0, stringListBusy - index);
        stringList = stringListTemp;
        stringList[index] = item;
        stringListBusy++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new NoStringException("Исходная строка отсутствует");
        } else if (index >= stringListBusy) {
            throw new InvalidIndexException("Неверный индекс");
        } else {
            stringList[index] = item;
            return item;
        }
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new NoStringException("Исходная строка отсутствует");
        } else {
            for (int i = 0; i < stringListBusy; i++) {
                if (stringList[i].equals(item)) {
                    int j = (stringListBusy--) - i - 1;
                    if (j != 0) {
                        System.arraycopy(stringList, i + 1, stringList, i, j);
                    }
                    return item;
                }
            }
            throw new NoStringException("Искомая строка отсутствует");
        }
    }

    @Override
    public String remove(int index) {
        if (index >= stringListBusy) {
            throw new InvalidIndexException("Неверный индекс");
        } else {
            String item = stringList[index];
            int j = (stringListBusy--) - index - 1;
            if (j != 0) {
                System.arraycopy(stringList, index + 1, stringList, index, j);
            }
            return item;
        }
    }

    @Override
    public boolean contains(String item) {
        return Arrays.asList(stringList).contains(item);
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        if (item == null) {
            throw new NoStringException("Исходная строка отсутствует");
        } else {
            for (int i = 0; i < stringListBusy; i++) {
                if (stringList[i].equals(item)) {
                    index = i;
                    break;
                }
            }
            return index;
        }
    }

    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        if (item == null) {
            throw new NoStringException("Исходная строка отсутствует");
        } else {
            for (int i = stringListBusy - 1; i >= 0; i--) {
                if (stringList[i].equals(item)) {
                    index = i;
                    break;
                }
            }
            return index;
        }
    }

    @Override
    public String get(int index) {
        if (index >= stringListBusy) {
            throw new InvalidIndexException("Неверный индекс");
        } else {
            return stringList[index];
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        boolean result = false;
        if (otherList == null) {
            throw new NoStringListException("Исходный массив отсутствует");
        } else if (stringList.length != otherList.length() || stringListBusy != otherList.size()) {
            return result;
        }
        for (int i = 0; i < stringListBusy; i++) {
            if (!stringList[i].equals(otherList.get(i))) {
                return result;
            }
        }
        result = true;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return stringListBusy == 0;
    }

    @Override
    public void clear() {
        if (stringListBusy != 0) {
            for (int i = 0; i < stringListBusy; i++) {
                stringList[i] = null;
            }
        }
        stringListBusy = 0;
    }

    @Override
    public String[] toArray() {
        String[] stringArray = new String[stringList.length];
        if (stringListBusy > 0) {
            System.arraycopy(stringList, 0, stringArray, 0, stringListBusy);
        } else {
            throw new InvalidStringListException("Массив пуст");
        }
        return stringArray;
    }

    public StringListImpl(String[] stringList, int stringListBusy) {
        this.stringList = stringList;
        this.stringListBusy = stringListBusy;
    }
}
