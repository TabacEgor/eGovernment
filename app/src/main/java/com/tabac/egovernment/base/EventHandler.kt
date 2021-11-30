package com.tabac.egovernment.base

interface EventHandler<T> {
    fun obtainEvent(event: T)
}