package com.curso.android.app.practica.equalstext.views

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.equalstext.R
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareString (){
        Espresso.onView(
            ViewMatchers.withId(R.id.texto1)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("")
            )
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.texto2)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("")
            )
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.textViewComparision)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("")
            )
        )
    }
}