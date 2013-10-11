package models;
// Generated 4 oct. 2013 11:25:37 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Documents generated by hbm2java
 */
@Named(value = "metadataController")
@SessionScoped
public class MetadataController  implements java.io.Serializable {
    private MetadataDAO metadataDao;
    private Metadata metadata;
    private static List<Metadata> metadatas = null;
    
    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Metadata> getMetadatas() {
        return metadatas;
    }

    public void setMetadatas(List<Metadata> metadatas) {
        MetadataController.metadatas = metadatas;
    }

    public MetadataController() {
	metadataDao = new MetadataDAO();
        metadata = new Metadata();
        ListeDesMetadata();
    }

    public void ListeDesMetadata() {
        if (metadatas == null) setMetadatas((metadataDao.getMetadata()));
    }
    
    public void ajouteMetadata() {
        metadata.setIdMd(metadataDao.ajouteMetadata(metadata));
        metadatas.add(metadata);
        metadata = new Metadata();
    
    }
}

