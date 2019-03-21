package ch.enterag.utils.base;

import java.io.*;
import java.util.*;

import ch.enterag.utils.SU;

public abstract class TestUtils
{
  private static Random _random = new Random(47);
  public static byte[] getBytes(int iLength)
  {
    byte[] buf = new byte[iLength];
    for (int i = 0; i < iLength; i++)
    {
      int j = i % 256;
      if (j > 127)
        j = j - 256;
      buf[i] = (byte)j;
    }
    return buf;
  } /* getBytes */
  
  public static byte[] getBytes(InputStream is)
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try
    {
      for (int iRead = is.read(); iRead != -1; iRead = is.read())
        baos.write(iRead);
      baos.close();
    }
    catch(IOException ie) { System.err.println(ie.getClass().getName()+": "+ie.getMessage()); }
    return baos.toByteArray();
  } /* getBytes */
  
  public static String getString(int iLength)
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < iLength; i++)
    {
      int j = i % 96;
      sb.appendCodePoint(32+j);
    }
    return sb.toString();
  } /* getString */
  
  public static String getString(Reader rdr)
  {
    StringWriter sw = new StringWriter();
    try
    {
      for (int iRead = rdr.read(); iRead != -1; iRead = rdr.read())
        sw.write((char)iRead);
      sw.close();
    }
    catch(IOException ie) { System.err.println(ie.getClass().getName()+": "+ie.getMessage()); }
    return sw.getBuffer().toString();
  } /* getString */

  public static String getNString(int iLength)
  {
    /* generate random bytes in the range [x20,xFF] */
    byte[] buf = new byte[iLength];
    for (int i = 0; i < iLength; i++)
    {
      int j = i % 192;
      if (j < 96)
        buf[i] = (byte)(32+j);
      else
        buf[i] = (byte)(64+j);
    }
    /* read them into a string as 1252 */
    return SU.getIsoLatin1String(buf);
  } /* getNString */
  
  public static String getNString(Reader rdr)
  {
    StringWriter sw = new StringWriter();
    try
    {
      for (int iRead = rdr.read(); iRead != -1; iRead = rdr.read())
        sw.write((char)iRead);
      sw.close();
    }
    catch(IOException ie) { System.err.println(ie.getClass().getName()+": "+ie.getMessage()); }
    return sw.getBuffer().toString();
  } /* getNString */

  public static int getRandomInteger()
  {
    return _random.nextInt();
  }
  
  public static short getRandomShort()
  {
    return (short)(_random.nextInt() & 0x0000FFFF);
  }
  
  public static long getRandomLong()
  {
    return _random.nextLong();
  }
  
  public static String getRandomFixedString(int iLength)
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < iLength; i++)
    {
      int j = (int)(96*_random.nextDouble());
      sb.appendCodePoint(32+j);
    }
    return sb.toString();
  }
  
  public static String getRandomString(int iMaxLength)
  {
    int iLength = (int)(iMaxLength*_random.nextDouble());
    return getRandomFixedString(iLength);
  }
  
  public static String getRandomFixedNString(int iLength)
  {
    /* generate random bytes in the range [x20,xFF] */
    byte[] buf = new byte[iLength];
    for (int i = 0; i < iLength; i++)
    {
      int j = (int)(192*_random.nextDouble());
      if (j < 96)
        buf[i] = (byte)(32+j);
      else
        buf[i] = (byte)(64+j);
    }
    /* read them into a string as 1252 */
    return SU.getIsoLatin1String(buf);
  }
  
  public static String getRandomNString(int iMaxLength)
  {
    int iLength = (int)(iMaxLength*_random.nextDouble());
    return getRandomFixedNString(iLength);
  }
  
  public static float getRandomFloat()
  {
    return _random.nextFloat();
  }
  
  public static double getRandomDouble()
  {
    return _random.nextDouble();
  }
  
  public static java.sql.Date getRandomDate()
  {
    long lCentury = 365L*100L;
    long lTime = 1000L*60L*60L*24L*(long)(lCentury*_random.nextDouble());
    return new java.sql.Date(lTime);
  }

  public static java.sql.Time getRandomTime()
  {
    long lDay = 1000L*60L*60L*24L;
    long lTime = (long)(lDay*_random.nextDouble());
    return new java.sql.Time(lTime);
  }
  
  public static java.sql.Timestamp getRandomTimestamp()
  {
    long lCentury = 1000L*60L*60L*24L*365L*100L;
    long lTime = (long)(lCentury*_random.nextDouble());
    return new java.sql.Timestamp(lTime);
  }
  
}
