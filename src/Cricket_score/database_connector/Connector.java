
package Cricket_score.database_connector;

import java.sql.ResultSet;

/**
 *
 * @author pankajan
 */
public interface Connector {
    
  public void connect();
  public ResultSet fetch(String sql);
  public void close();
}
