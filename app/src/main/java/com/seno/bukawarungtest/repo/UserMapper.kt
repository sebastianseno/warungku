package com.seno.bukawarungtest.repo

import com.seno.bukawarungtest.db.entity.UserDb
import com.seno.bukawarungtest.rest.Data

fun Data.toDb(): UserDb {
    return UserDb(
    id,firstName,lastName, email, avatar
    )
}