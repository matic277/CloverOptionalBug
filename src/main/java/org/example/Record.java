package org.example;


import java.util.SortedMap;
import java.util.TreeMap;


public class Record
{
  private final SortedMap<Integer, String> m_list;
  private final String m_delimiter;
  private int m_index;
  
  private static final String ENDLINE = "\n";
  
  public Record(String delimiter)
  {
    this(delimiter, 0);
  }
  
  public Record(String delimiter, int startIndex)
  {
    m_delimiter = delimiter;
    m_index = startIndex;
    
    m_list = new TreeMap<>();
  }
  
  private Record(String delimiter, int startIndex, SortedMap<Integer, String> sortedMap)
  {
    m_delimiter = delimiter;
    m_index = startIndex;
    m_list = new TreeMap<>(sortedMap);
  }
  
  public Record add(String s)
  {
    if (m_list.containsKey(m_index))
    {
      throw new Error("Attempt to assign String to already occupied field");
    }
    m_list.put(m_index, s);
    m_index++;
    return this;
  }
  
  public void goTo(int index)
  {
    m_index = index;
  }
  
  public Record add(String s, int index)
  {
    goTo(index);
    add(s);
    return this;
  }
  
  @Override
  public String toString()
  {
    final int begin = m_list.firstKey();
    final int end = m_list.lastKey();
    final var sb = new StringBuilder();
    for (int i = begin; i <= end; i++)
    {
      String str = m_list.get(i);
      if (str != null)
      {
        sb.append(str);
      }
      sb.append(m_delimiter);
    }
    sb.append(ENDLINE);
    return sb.toString();
  }
  
  public String toString(int first, int last)
  {
    final int beginKey = m_list.firstKey();
    final int endKey = m_list.lastKey();
    final int begin = Math.max(beginKey, first);
    final int end   = Math.min(endKey,   last);
    final var sb = new StringBuilder();
    for (int i = begin; i <= end; i++)
    {
      String str = m_list.get(i);
      if (str != null)
      {
        sb.append(str);
      }
      sb.append(m_delimiter);
    }
    sb.append(ENDLINE);
    return sb.toString();
  }
  
  public SortedMap<Integer, String> getList()
  {
    return m_list;
  }
}
