package com.bfw.domain;

public class MeetingRoom {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_id
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    private Integer meetingroomId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_name
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    private String meetingroomName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_size
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    private String meetingroomSize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_note
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    private String meetingroomNote;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column meeting_room.meetingroom_state
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    private String meetingroomState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_room.meetingroom_id
     *
     * @return the value of meeting_room.meetingroom_id
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public Integer getMeetingroomId() {
        return meetingroomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_room.meetingroom_id
     *
     * @param meetingroomId the value for meeting_room.meetingroom_id
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public void setMeetingroomId(Integer meetingroomId) {
        this.meetingroomId = meetingroomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_room.meetingroom_name
     *
     * @return the value of meeting_room.meetingroom_name
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public String getMeetingroomName() {
        return meetingroomName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_room.meetingroom_name
     *
     * @param meetingroomName the value for meeting_room.meetingroom_name
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public void setMeetingroomName(String meetingroomName) {
        this.meetingroomName = meetingroomName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_room.meetingroom_size
     *
     * @return the value of meeting_room.meetingroom_size
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public String getMeetingroomSize() {
        return meetingroomSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_room.meetingroom_size
     *
     * @param meetingroomSize the value for meeting_room.meetingroom_size
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public void setMeetingroomSize(String meetingroomSize) {
        this.meetingroomSize = meetingroomSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_room.meetingroom_note
     *
     * @return the value of meeting_room.meetingroom_note
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public String getMeetingroomNote() {
        return meetingroomNote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_room.meetingroom_note
     *
     * @param meetingroomNote the value for meeting_room.meetingroom_note
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public void setMeetingroomNote(String meetingroomNote) {
        this.meetingroomNote = meetingroomNote;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column meeting_room.meetingroom_state
     *
     * @return the value of meeting_room.meetingroom_state
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public String getMeetingroomState() {
        return meetingroomState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column meeting_room.meetingroom_state
     *
     * @param meetingroomState the value for meeting_room.meetingroom_state
     *
     * @mbggenerated Wed May 21 13:51:45 CST 2014
     */
    public void setMeetingroomState(String meetingroomState) {
        this.meetingroomState = meetingroomState;
    }

	@Override
	public String toString() {
		return "MeetingRoom [meetingroomId=" + meetingroomId
				+ ", meetingroomName=" + meetingroomName + ", meetingroomSize="
				+ meetingroomSize + ", meetingroomNote=" + meetingroomNote
				+ ", meetingroomState=" + meetingroomState + "]";
	}
    
    
    
}