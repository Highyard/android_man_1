package com.example.courseratingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.courseratingapp.domain.Course;

public class RateCourse extends AppCompatActivity {

    private static final String TAG = "RateCourseActivity";

    final static String RATING = "RATING";

    private RatingBar subjectRelevance;
    private RatingBar teacherPerformance;
    private RatingBar teacherPreparation;
    private RatingBar teacherFeedback;
    private RatingBar exampleQuality;
    private RatingBar jobOpportunities;


    private TextView subjectText;
    private TextView teacherPerText;
    private TextView teacherPrepText;
    private TextView teacherFeedText;
    private TextView exampleText;
    private TextView jobOppText;

    private Button submit;

    private final Course pythonCourse    = new Course(0,0);
    private final Course C_Course        = new Course(0,0);
    private final Course JSCourse        = new Course(0,0);
    private final Course angularCourse   = new Course(0,0);
    private final Course nodeJSCourse    = new Course(0,0);
    private final Course javaCourse      = new Course(0,0);

    Float pythonRetrievedOverallRating,
            C_RetrievedOverallRating,
            JS_RetrievedOverallRating,
            angularRetrievedOverallRating,
            nodejsRetrievedOverallRating,
            javaRetrievedOverallRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_course);
        Log.d(TAG, getString(R.string.onCreate));
        init();

        // get Intent from CoursesPageActivity class and store the Action from intent in a String //
        Intent receivedIntent = getIntent();
        final String receivedAction = receivedIntent.getAction();

        // Logs the received Action from CoursesPageActivity class, e.g. ACTION_PYTHON = "PYTHON" //
        Log.d(TAG, receivedAction);

        try {

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = getApplication();
                    SharedPreferences sharedPrefs = context.getSharedPreferences(getString(R.string.COURSE_RATINGS_KEY), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPrefs.edit();

                    switch (receivedAction) {
                        case (CoursesPageActivity.ACTION_PYTHON):

                            pythonRetrievedOverallRating = sharedPrefs.getFloat(getString(R.string.python_rating_key), getResources().getInteger(R.integer.defaultValue));

                            // Check if there is a rating above 0 already stored //
                            if (pythonRetrievedOverallRating != getResources().getInteger(R.integer.defaultValue))
                                // If there is we want to set the overall rating of the python course to that retrieved value//
                                pythonCourse.setCurrentOverallRating(pythonRetrievedOverallRating);

                            // Takes all the ratings, adds them all together and sets this value on course.newRating //
                            pythonCourse.setNewRating(subjectRelevance.getRating() + teacherPerformance.getRating() + teacherPreparation.getRating() + teacherFeedback.getRating() + exampleQuality.getRating() + jobOpportunities.getRating());

                            // Takes the new rating and adds it to the already existing overall rating //
                            pythonCourse.setCurrentOverallRating(pythonCourse.getCurrentOverallRating() + pythonCourse.getNewRating());
                            // Adds the new overall rating to the sharedPreferences file //
                            editor.putFloat(getString(R.string.python_rating_key), pythonCourse.getCurrentOverallRating());
                            editor.apply();

                            // Resets the current rating back to 0 //
                            pythonCourse.setNewRating(0);

                            // Assign key and value on intent that is sent back to CoursesPageActivity //
                            Intent pythonCourseIntent = new Intent();
                            pythonCourseIntent.putExtra(RATING, pythonCourse);
                            setResult(RESULT_OK, pythonCourseIntent);
                            break;

                        case (CoursesPageActivity.ACTION_C):

                            C_RetrievedOverallRating = sharedPrefs.getFloat(getString(R.string.c_rating_key), getResources().getInteger(R.integer.defaultValue));

                            if (C_RetrievedOverallRating != getResources().getInteger(R.integer.defaultValue))
                                C_Course.setCurrentOverallRating(C_RetrievedOverallRating);

                            C_Course.setNewRating(subjectRelevance.getRating() + teacherPerformance.getRating() + teacherPreparation.getRating() + teacherFeedback.getRating() + exampleQuality.getRating() + jobOpportunities.getRating());

                            C_Course.setCurrentOverallRating(C_Course.getCurrentOverallRating() + C_Course.getNewRating());

                            editor.putFloat(getString(R.string.c_rating_key), C_Course.getCurrentOverallRating());
                            editor.apply();

                            C_Course.setNewRating(0);

                            Intent C_courseIntent = new Intent();
                            C_courseIntent.putExtra(RATING, C_Course);
                            setResult(RESULT_OK, C_courseIntent);
                            break;

                        case (CoursesPageActivity.ACTION_JS):

                            JS_RetrievedOverallRating = sharedPrefs.getFloat(getString(R.string.js_rating_key), getResources().getInteger(R.integer.defaultValue));

                            if (JS_RetrievedOverallRating != getResources().getInteger(R.integer.defaultValue))
                                JSCourse.setCurrentOverallRating(JS_RetrievedOverallRating);

                            JSCourse.setNewRating(subjectRelevance.getRating() + teacherPerformance.getRating() + teacherPreparation.getRating() + teacherFeedback.getRating() + exampleQuality.getRating() + jobOpportunities.getRating());

                            JSCourse.setCurrentOverallRating(JSCourse.getCurrentOverallRating() + JSCourse.getNewRating());

                            editor.putFloat(getString(R.string.js_rating_key), JSCourse.getCurrentOverallRating());
                            editor.apply();

                            JSCourse.setNewRating(0);

                            Intent JS_courseIntent = new Intent();
                            JS_courseIntent.putExtra(RATING, JSCourse);
                            setResult(RESULT_OK, JS_courseIntent);
                            break;

                        case (CoursesPageActivity.ACTION_ANGULAR):

                            angularRetrievedOverallRating = sharedPrefs.getFloat(getString(R.string.angular_rating_key), getResources().getInteger(R.integer.defaultValue));

                            if (angularRetrievedOverallRating != getResources().getInteger(R.integer.defaultValue))
                                angularCourse.setCurrentOverallRating(angularRetrievedOverallRating);

                            angularCourse.setNewRating(subjectRelevance.getRating() + teacherPerformance.getRating() + teacherPreparation.getRating() + teacherFeedback.getRating() + exampleQuality.getRating() + jobOpportunities.getRating());

                            angularCourse.setCurrentOverallRating(angularCourse.getCurrentOverallRating() + angularCourse.getNewRating());

                            editor.putFloat(getString(R.string.angular_rating_key), angularCourse.getCurrentOverallRating());
                            editor.apply();

                            angularCourse.setNewRating(0);

                            Intent angularCourseIntent = new Intent();
                            angularCourseIntent.putExtra(RATING, angularCourse);
                            setResult(RESULT_OK, angularCourseIntent);
                            break;

                        case (CoursesPageActivity.ACTION_NODEJS):

                            nodejsRetrievedOverallRating = sharedPrefs.getFloat(getString(R.string.nodejs_rating_key), getResources().getInteger(R.integer.defaultValue));

                            if (nodejsRetrievedOverallRating != getResources().getInteger(R.integer.defaultValue))
                                nodeJSCourse.setCurrentOverallRating(nodejsRetrievedOverallRating);

                            nodeJSCourse.setNewRating(subjectRelevance.getRating() + teacherPerformance.getRating() + teacherPreparation.getRating() + teacherFeedback.getRating() + exampleQuality.getRating() + jobOpportunities.getRating());

                            nodeJSCourse.setCurrentOverallRating(pythonCourse.getCurrentOverallRating() + nodeJSCourse.getNewRating());

                            editor.putFloat(getString(R.string.nodejs_rating_key), nodeJSCourse.getCurrentOverallRating());
                            editor.apply();

                            nodeJSCourse.setNewRating(0);

                            Intent nodeJS_courseIntent = new Intent();
                            nodeJS_courseIntent.putExtra(RATING, nodeJSCourse);
                            setResult(RESULT_OK, nodeJS_courseIntent);
                            break;

                        case (CoursesPageActivity.ACTION_JAVA):

                            javaRetrievedOverallRating = sharedPrefs.getFloat(getString(R.string.java_rating_key), getResources().getInteger(R.integer.defaultValue));

                            if (javaRetrievedOverallRating != getResources().getInteger(R.integer.defaultValue))
                                javaCourse.setCurrentOverallRating(javaRetrievedOverallRating);

                            javaCourse.setNewRating(subjectRelevance.getRating() + teacherPerformance.getRating() + teacherPreparation.getRating() + teacherFeedback.getRating() + exampleQuality.getRating() + jobOpportunities.getRating());

                            javaCourse.setCurrentOverallRating(javaCourse.getCurrentOverallRating() + javaCourse.getNewRating());

                            editor.putFloat(getString(R.string.java_rating_key), javaCourse.getCurrentOverallRating());
                            editor.apply();

                            javaCourse.setNewRating(0);

                            Intent javaCourseIntent = new Intent();
                            javaCourseIntent.putExtra(RATING, javaCourse);
                            setResult(RESULT_OK, javaCourseIntent);
                            break;
                    }
                    // Free this activity from memory once we have our result //
                    RateCourse.this.finish();
                }
            });
        } catch (NullPointerException e) {
            Log.d(TAG, e.toString());
            Log.d(TAG, getString(R.string.nullPointerAction));
        }

    }

    protected void init () {
        Log.d(TAG, getString(R.string.init));
        subjectRelevance = findViewById(R.id.r1);
        teacherPerformance = findViewById(R.id.r2);
        teacherPreparation = findViewById(R.id.r3);
        teacherFeedback = findViewById(R.id.r4);
        exampleQuality = findViewById(R.id.r5);
        jobOpportunities = findViewById(R.id.r6);

        subjectText = findViewById(R.id.tv1);
        teacherPerText = findViewById(R.id.tv2);
        teacherPrepText = findViewById(R.id.tv3);
        teacherFeedText = findViewById(R.id.tv4);
        exampleText = findViewById(R.id.tv5);
        jobOppText = findViewById(R.id.tv6);

        submit = findViewById(R.id.b1);
    }

}
