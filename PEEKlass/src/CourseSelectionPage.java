import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CourseSelectionPage  extends JPanel{
	private JPanel showClassesPanel;
	private JPanel filterPanel;
	private JPanel mainPanel;
	private JPanel showGridPanel;
	private JPanel showMustTakePanel;
	private JPanel showSelectedPanel;
	private JPanel bottomPanel;
	public static int numMAJOR = 0;
	public static int numMWF = 1;
	public static int numTTH = 2;
	public static int numNOTTAKEN = 3;
	public static int numMEETSPREREQ = 4;
	private FilterCourses filterCourses = new FilterCourses(this);
	private JScrollPane classListPane;
	private boolean[] filterValues = new boolean[5];
	
	
	public CourseSelectionPage() 
	{
		super(new BorderLayout());
		setFocusable(true);
		initPanel();
	}
	
	//initializes all panels
	public void initPanel(){
		for (int i = 0; i < 5; i++){
			filterValues[i] = false;
		}
		add(filterPanel(), BorderLayout.NORTH);
		add(mainPanel(), BorderLayout.CENTER);
		add(bottomPanel(), BorderLayout.SOUTH);
	}
	
	//top filter panel
	public JPanel filterPanel(){
		filterPanel = new JPanel(new BorderLayout());
		JLabel filterLabel = new JLabel("Filter");
		filterPanel.add(filterLabel, BorderLayout.NORTH);
		filterPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		filterLabel.setHorizontalAlignment(JLabel.CENTER);
		filterLabel.setVerticalAlignment(JLabel.CENTER);
		filterLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		JCheckBox major = new JCheckBox("Major");
		major.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterValues[numMAJOR] = !filterValues[numMAJOR];

            }
        });
		JCheckBox MWF = new JCheckBox("Mon, Wed, Fri");
		MWF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	filterValues[numMWF] = !filterValues[numMWF];
            }
        });
		JCheckBox TTH = new JCheckBox("Tues, Thurs");
		TTH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	filterValues[numTTH] = !filterValues[numTTH];
            }
        });
		JCheckBox notTaken = new JCheckBox("Not Taken Before");
		notTaken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		filterValues[numNOTTAKEN] = !filterValues[numNOTTAKEN];
            }
        });
		JCheckBox meetsPrereq = new JCheckBox("Meets Prerequisites");
		meetsPrereq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	filterValues[numMEETSPREREQ] = !filterValues[numMEETSPREREQ];
            }
        });
		
		JPanel checkBoxesPanel = new JPanel(new FlowLayout());
		checkBoxesPanel.add(major);
		checkBoxesPanel.add(MWF);
		checkBoxesPanel.add(TTH);
		checkBoxesPanel.add(notTaken);
		checkBoxesPanel.add(meetsPrereq);
		
		//TODO
		//should display info sent from filterCourses class
		JButton searchButton = new JButton("Seach");
		searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		        showClassesPanel.removeAll();
		        showClassesPanel.revalidate();
            	HashMap<CourseNum, Course> filteredCourseList = filterCourses.filterAll();
            	System.out.println(filteredCourseList);
		        for (CourseNum key : filteredCourseList.keySet()){
		            	//iterate over key
		        		CourseNum courseNum = key;
		        		Course course = filteredCourseList.get(key);
		        		//JPanel eachCourse = new CourseToDisplay(courseNum, course);
		        		showClassesPanel.add(new CourseToDisplay(courseNum, course));
		        		
		        }
		        showClassesPanel.revalidate();
            }
        });
		
		checkBoxesPanel.add(searchButton);
		filterPanel.add(checkBoxesPanel, BorderLayout.CENTER);
		return filterPanel;
	}
	
	//main panel in the center containing left - class list, right - grid
	public JPanel mainPanel(){
		mainPanel = new JPanel(new GridLayout(1,2));
		mainPanel.add(showClassesPanel());
		mainPanel.add(showGridPanel());
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		return mainPanel;
	}
	
	//center left panel showing class list from filter
	public JPanel showClassesPanel(){
		showClassesPanel = new JPanel();
		showClassesPanel.setLayout(new BoxLayout(showClassesPanel, BoxLayout.PAGE_AXIS));
		showClassesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//classListPane = new JScrollPane(showClassesPanel);
		return showClassesPanel;
	}
	
	//center right panel showing class grid
	public JPanel showGridPanel(){
		showGridPanel = new JPanel(new BorderLayout());
		showGridPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel scheduleGridPanel = new JPanel();
	    scheduleGridPanel.setLayout(new GridLayout(10,6,1,1));
	    showGridPanel.add(scheduleGridPanel, BorderLayout.CENTER);
	    JPanel emptyPanel = new JPanel();
	    //0,0
	    scheduleGridPanel.add(emptyPanel);
	    /**
	    JLabel monday= new JLabel("Monday");
	    monday.setBorder(BorderFactory.createLineBorder(Color.black));
	    JLabel tuesday= new JLabel("Tuesday");
	    tuesday.setBorder(BorderFactory.createLineBorder(Color.black));
	    JLabel wednesday= new JLabel("Wednesday");
	    wednesday.setBorder(BorderFactory.createLineBorder(Color.black));
	    JLabel thursday= new JLabel("Thursday");
	    thursday.setBorder(BorderFactory.createLineBorder(Color.black));
	    JLabel friday= new JLabel("Friday");
	    friday.setBorder(BorderFactory.createLineBorder(Color.black));
	    scheduleGridPanel.add(monday);
	    scheduleGridPanel.add(tuesday);
	    scheduleGridPanel.add(wednesday);
	    scheduleGridPanel.add(thursday);
	    scheduleGridPanel.add(friday);**/
		return showGridPanel;
	}
	
	
	
	//bottom left panel showing classes that must be taken (check mark)
	public JPanel showMustTakePanel(){
		showMustTakePanel = new JPanel();
		showMustTakePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		showMustTakePanel.setBackground(Color.red);
		return showMustTakePanel;
	}
	
	//bottom right panel showing classes that are selected but not necessary or clashes with other classes
	public JPanel showSelectedPanel(){
		showSelectedPanel = new JPanel();
		showSelectedPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		showSelectedPanel.setBackground(Color.yellow);
		return showSelectedPanel;
	}
	
	//bottom panel containing left - must take classes, right - other selected classes
	public JPanel bottomPanel(){
		bottomPanel = new JPanel(new GridLayout(1,2));
		bottomPanel.add(showMustTakePanel());
		bottomPanel.add(showSelectedPanel());
		return bottomPanel;
	}
	/**
	
	public JPanel scheduleGridPanel(){
	    JPanel scheduleGridPanel = new JPanel();
	    scheduleGridPanel.setLayout(new GridLayout(2,2,1,1));
	    //JButton component= new JButton("Component");
	    //panel.add(component, 0,0 );
	}**/
	
	public boolean getFilterValues(int i){
		return filterValues[i];
	}
}
