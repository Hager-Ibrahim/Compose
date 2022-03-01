package com.example.compose.ui.commons.livedata
/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write
    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content

    /**
     * Method to just reduce null check every time [getContentIfNotHandled] is called
     */
    fun doWith(block: ((T) -> Unit)) {
        getContentIfNotHandled()?.let { block(content) }
    }
}

/**
 * Easy way to get an event instance instead of looking for the event class declaration
 *
 */
fun <T> event(value: T) = Event(value)