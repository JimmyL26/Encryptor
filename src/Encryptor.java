public class Encryptor
{
  /** A two-dimensional array of single-character strings, instantiated in the constructor */
  private String[][] letterBlock;

  /** The number of rows of letterBlock, set by the constructor */
  private int numRows;

  /** The number of columns of letterBlock, set by the constructor */
  private int numCols;

  /** Constructor*/
  public Encryptor(int r, int c)
  {
    letterBlock = new String[r][c];
    numRows = r;
    numCols = c;
  }

  public String[][] getLetterBlock()
  {
    return letterBlock;
  }

  /** Places a string into letterBlock in row-major order.
   *
   *   @param str  the string to be processed
   *
   *   Postcondition:
   *     if str.length() < numRows * numCols, "A" in each unfilled cell
   *     if str.length() > numRows * numCols, trailing characters are ignored
   */
  public void fillBlock(String str) {
    /* to be implemented in part (a) */
    int index = 0;
    int length = str.length();
    if (str.length() > numRows * numCols)
    {
      length = numRows * numCols;
    }
    for (int i = 0; i < letterBlock.length; i++)
    {
      for (int j = 0; j < letterBlock[i].length; j++)
      {
        if (index < length)
        {
          letterBlock[i][j] = str.substring(index, index + 1);
        }
        else
        {
          letterBlock[i][j] = "A";
        }
        index++;
      }
    }
  }

  /** Extracts encrypted string from letterBlock in column-major order.
   *
   *   Precondition: letterBlock has been filled
   *
   *   @return the encrypted string from letterBlock
   */
  public String encryptBlock()
  {
    /* to be implemented in part (b) */
    String encryptedString = "";
    for (int i = 0; i < letterBlock[0].length; i++)
    {
      for (int j = 0; j < letterBlock.length; j++)
      {
        encryptedString += letterBlock[j][i];
      }
    }
    return encryptedString;
  }

  /** Encrypts a message.
   *
   *  @param message the string to be encrypted
   *
   *  @return the encrypted message; if message is the empty string, returns the empty string
   */
  public String encryptMessage(String message)
  {
    /* to be implemented in part (c) */
    String encrypt = "";
    for (int i = 0; i < message.length(); i += numRows * numCols)
    {
      fillBlock(message.substring(i));
      encrypt += encryptBlock();
    }
    return encrypt;
  }

  /**  Decrypts an encrypted message. All filler 'A's that may have been
   *   added during encryption will be removed, so this assumes that the
   *   original message (BEFORE it was encrypted) did NOT end in a capital A!
   *
   *   NOTE! When you are decrypting an encrypted message,
   *         be sure that you have initialized your Encryptor object
   *         with the same row/column used to encrypted the message! (i.e.
   *         the “encryption key” that is necessary for successful decryption)
   *         This is outlined in the precondition below.
   *
   *   Precondition: the Encryptor object being used for decryption has been
   *                 initialized with the same number of rows and columns
   *                 as was used for the Encryptor object used for encryption.
   *
   *   @param encryptedMessage  the encrypted message to decrypt
   *
   *   @return  the decrypted, original message (which had been encrypted)
   *
   *   TIP: You are encouraged to create other helper methods as you see fit
   *        (e.g. a method to decrypt each section of the decrypted message,
   *         similar to how encryptBlock was used)
   */
  public String decryptMessage(String encryptedMessage)
  {
    /* to be implemented in part (d) */

  }
}