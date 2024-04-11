package com.home.practice.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(String topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(value="/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @RequestMapping(value="/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course, @PathVariable String id){
        courseService.updateCourse(id, course);
    }

    @RequestMapping(value="/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
