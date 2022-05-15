public class List {
    private Object[] list;
    private int length = 0;

    //добавление элемента в список
    public void add(Object newObj)
    {
        if (list == null)
        {
            list = new Object[1];
            list[0] = newObj;

            length = list.length;
        }
        else
        {
            Object[] copy = new Object[list.length + 1];
            for(int i = 0; i < list.length; ++i)
            {
                copy[i] = list[i];
            }
            copy[copy.length - 1] = newObj;
            list = copy;

            length = list.length;
        }
    }

    //получение индекса из списка
    public Object get(int index)
    {
        return list[index];
    }

    //поиск первого вхождения элемента в списке
    public int indexOf(Object obj)
    {
        for(int i = 0; i < list.length; ++i)
        {
            if(list[i] == obj)
            {
                return i;
            }
        }
        return -1;
    }

    //поиск последнего вхождения элемента в списке
    public int lastindexOf(Object obj)
    {
        for(int i = list.length - 1; i >= 0; --i)
        {
            if(list[i] == obj)
            {
                return i;
            }
        }
        return -1;
    }

    //присваивание значения элемента по индексу
    public void set(int index, Object obj)
    {
        list[index] = obj;
    }

    //получает набор элементов, которые находятся в списке между индексами start и end
    public List subList(int start, int end) throws Exception
    {
        if (start > end || start > list.length || start < 0 || end > list.length || end < 0)
            throw new Exception("Index error");

        List copy = new List();
        for(int i = start; i < end; ++i) {
            copy.add(list[i]);
        }
        return copy;
    }

    //удаление элемента по индексу
    public void remove(int index) {
        Object[] copy = new Object[list.length - 1];
        for (int i = 0, j = 0; i < list.length; i++) {
            if (i != index) {
                copy[j++] = list[i];
            }
        }
        list = copy;
        length = list.length;
    }

    //возвращение длинны списка
    public int length()
    {
        return length;
    }

    //печать списка
    public void print()
    {
        for (int i = 0; i < list.length; ++i) {
            System.out.print(list[i] + " ");
        }
    }
}
