package es.ieci.tecdoc.isicres.admin.sbo.fss.core;

import es.ieci.tecdoc.isicres.admin.base.dbex.DbConnection;
import es.ieci.tecdoc.isicres.admin.core.db.DBSessionManager;
import es.ieci.tecdoc.isicres.admin.sbo.util.types.SboType;


public final class FssBnoFile
{	

	//~ Constructors -----------------------------------------------------------

	private FssBnoFile(){}

	//~ Methods ----------------------------------------------------------------

	public static byte [] retrieveFile(int fileId, String entidad)
								 throws Exception
	{

		byte [] fileCont = null;

		DbConnection dbConn=new DbConnection();  
		try
		{

			dbConn.open(DBSessionManager.getSession());
			
			fileCont = FssMdoFile.retrieveFile(dbConn, fileId, entidad);


		}
		 catch(Exception e)
		{
			 throw (e);
		}finally{
			dbConn.close();
		}
			return fileCont;
	}
	
	// Si el fichero no tiene b�squeda en contenido de documento dejar
	// ftsInfo a null
	public static int storeFileInVolume(int volId, FssFileInfo info,
										         FssFtsInfo ftsInfo, byte [] fileCont, String entidad)
							throws Exception
	{

		int fileId = SboType.NULL_ID;

		DbConnection dbConn=new DbConnection();  
		try
		{
			dbConn.open(DBSessionManager.getSession());
         
			fileId = FssMdoFile.storeFileInVolume(dbConn, volId, info, ftsInfo,
                                               fileCont, entidad);
		}
		 catch(Exception e)
		{
			 throw (e);
		}finally{
			dbConn.close();
		}
		return fileId;
	}	

	// Si el fichero no tiene b�squeda en contenido de documento dejar
	// ftsInfo a null
	public static int storeFileInList(int listId, FssFileInfo info,
									          FssFtsInfo ftsInfo, 
                                     byte [] fileCont, String entidad)
						   throws Exception
	{

		int fileId = SboType.NULL_ID;

		DbConnection dbConn=new DbConnection();
		try
		{

			dbConn.open(DBSessionManager.getSession());
			
			fileId = FssMdoFile.storeFileInList(dbConn, listId, info, ftsInfo,
                                             fileCont, entidad);

		}
		 catch(Exception e)
		{
			 throw (e);
		}finally{
			dbConn.close();
		}
			return fileId;
	}
	
	public static void deleteFile(int fileId, String entidad)
						    throws Exception
	{
		DbConnection dbConn=new DbConnection();
		try
		{
			dbConn.open(DBSessionManager.getSession());
			FssMdoFile.deleteFile(dbConn, fileId, entidad);
		}
		 catch(Exception e)
		{
			 throw(e);
		}finally{
			dbConn.close();
		}

	}

}
 // class
