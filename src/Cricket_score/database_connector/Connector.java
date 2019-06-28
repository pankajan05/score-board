
package Cricket_score.database_connector;

import java.sql.Statement;

/**
 *
 * @author pankajan
 */
public interface Connector {
    
  public Statement connect();
  public void close();
}
