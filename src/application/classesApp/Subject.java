package application.classesApp;

import java.util.ArrayList;

/**
 * @author ponthieu
 * <b>Subject</b> is in a school class and contains topics
 */
public class Subject {

    /**
     * Default constructor
     */
	public Subject(int idSubject, String nameSubject) {
    	this.idSubject = idSubject;
    	this.nameSubject = nameSubject;
    }

    public Subject(int idSubject, String nameSubject, ArrayList<Topic> listofTopics) {
		super();
		this.idSubject = idSubject;
		this.nameSubject = nameSubject;
		this.listofTopics = listofTopics;
	}
    
    public Subject(int idSubject, String nameSubject, int idSchoolClass) {
    	this.idSubject = idSubject;
    	this.nameSubject = nameSubject;
    	this.idSchoolClass = idSchoolClass;
    }
    
    private int idSubject;

	/**
     * 
     */
	private String nameSubject;

	private int idSchoolClass;


    /**
     * 
     */
    private ArrayList<Topic> listofTopics;


    /**
     * Get all the topics for a subject
     * @return list of topics for a subject
     */
    public ArrayList<Topic> getTopics() {
        return this.listofTopics;
    }

    /**
     * Add a topic for a subject
     * @param top topic added
     */
    public void addTopic(Topic top) {
       this.listofTopics.add(top);
    }

    /**
     * Delete a topic for a subject
     * @param top topic deleted
     */
    public void deleteTopic(Topic top) {
        this.listofTopics.remove(top);
    }
    
    /**
     * Delete a topic for a subject
     * @param top topic deleted
     */
    public void deleteTopicById(int id) {
    	for (Topic topic : listofTopics) {
			if (topic.getId() == id) {
				 this.listofTopics.remove(topic);
			}
		}
       
    }
    
    /**
     * getter id
     * @return the subject's id
     */
    public int getId() {
		return idSubject;
	}
    
    /**
     * setter id
     * @param idSubject
     */
    

	public void setId(int idSubject) {
		this.idSubject = idSubject;
	}

	/**
     * Get the name of the subject
     * @return name of the subject
     */
    public String getNameSubject() {
        // TODO implement here
        return nameSubject;
    }

    /**
     * Change the name of the subject
     * @param value new name of the subject
     */
    public void setNameSubject(String nameSubject) {
       this.nameSubject = nameSubject;
    }

	public int getIdSchoolClass() {
		return idSchoolClass;
	}

	public void setIdSchoolClass(int idSchoolClass) {
		this.idSchoolClass = idSchoolClass;
	}
    
    

}