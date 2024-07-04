/*======================================================================
BaseSqlXml implements a wrapped SQLXML object.
Version     : $Id: $
Application : SIARD2
Description : BaseSqlXml implements a wrapped SQLXML object.
              See https://docs.oracle.com/javase/7/docs/api/java/sql/SQLXML.html
Platform    : Java 7   
------------------------------------------------------------------------
Copyright  : 2016, Enter AG, Rüti ZH, Switzerland
Created    : 30.03.2016, Hartwig Thomas
======================================================================*/
package ch.enterag.utils.jdbc;

import java.io.*;
import java.sql.*;
import javax.xml.transform.*;

/*====================================================================*/
/** BaseSqlXml implements a wrapped SQLXML object.
 * for derived JDBC wrappers.
 * @author Hartwig Thomas
 */
public abstract class BaseSqlXml
  implements SQLXML
{
  /** wrapped SQLXML */
  private SQLXML _sqlxmlWrapped = null;

  /*------------------------------------------------------------------*/
  /** constructor
   * @param arrayWrapped connection to be wrapped.
   */
  public BaseSqlXml(SQLXML sqlxmlWrapped)
  {
    _sqlxmlWrapped = sqlxmlWrapped;
  } /* constructor BaseSqlXml */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public InputStream getBinaryStream() throws SQLException
  {
    return _sqlxmlWrapped.getBinaryStream();
  } /* getBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public OutputStream setBinaryStream() throws SQLException
  {
    return _sqlxmlWrapped.setBinaryStream();
  } /* setBinaryStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Reader getCharacterStream() throws SQLException
  {
    return _sqlxmlWrapped.getCharacterStream();
  } /* getCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public Writer setCharacterStream() throws SQLException
  {
    return _sqlxmlWrapped.setCharacterStream();
  } /* setCharacterStream */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public String getString() throws SQLException
  {
    return _sqlxmlWrapped.getString();
  } /* getString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void setString(String value) throws SQLException
  {
    _sqlxmlWrapped.setString(value);
  } /* setString */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public <T extends Source> T getSource(Class<T> sourceClass)
    throws SQLException
  {
    return _sqlxmlWrapped.getSource(sourceClass);
  } /* getSource */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public <T extends Result> T setResult(Class<T> resultClass)
    throws SQLException
  {
    return _sqlxmlWrapped.setResult(resultClass);
  } /* setResult */

  /*------------------------------------------------------------------*/
  /** {@inheritDoc} */
  @Override
  public void free() throws SQLException
  {
    _sqlxmlWrapped.free();
  } /* free */

} /* BaseSqlXml */
