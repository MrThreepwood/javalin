/*
 * Javalin - https://javalin.io
 * Copyright 2017 David Åse
 * Licensed under Apache 2.0: https://github.com/tipsy/javalin/blob/master/LICENSE
 */

package io.javalin.core.validation

open class BodyValidator<T>(value: T?) : BaseValidator<T>(value, value.fieldName()) {
    fun check(check: Check<T>, error: String) = check(value.fieldName(), check, error)
    fun check(check: Check<T>, error: ValidationError<T>) = check(value.fieldName(), check, error)
    fun check(fieldName: String, check: Check<T>, error: String) = addRule(fieldName, { check(it!!) }, error) as BodyValidator<T>
    fun check(fieldName: String, check: Check<T>, error: ValidationError<T>) = addRule(fieldName, { check(it!!) }, error) as BodyValidator<T>
    override fun get(): T = super.get()!!
}

fun Any?.fieldName() = this!!::class.java.simpleName
