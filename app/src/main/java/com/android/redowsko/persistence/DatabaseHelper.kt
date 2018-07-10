package com.android.redowsko.persistence

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.android.redowsko.persistence.model.*

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "db_redowsko", null, 1) {

    companion object {
        const val TABLE_QUESTION = "tb_question"
        const val TABLE_HOSPITAL = "tb_hospital"
        const val TABLE_SURVERIOR = "tb_surverior"
        const val TABLE_SURVERIOR_TASK = "tb_surverior_task"
        const val TABLE_ANSWER = "tb_answer"
    }

    override fun onCreate(p0: SQLiteDatabase?) {

        val CREATE_QUESTION_TABLE = "CREATE TABLE $TABLE_QUESTION (" +
                "id_question INT(20) PRIMARY KEY NOT NULL," +
                "question TEXT," +
                "bab TEXT," +
                "area TEXT," +
                "standar TEXT," +
                "ep TEXT," +
                "created_at TIMESTAMP," +
                "updated_at TIMESTAMP," +
                "id_surverior INT(20)" +
                ")"

        val CREATE_HOSPITAL_TABLE = "CREATE TABLE $TABLE_HOSPITAL (" +
                "id_hospital INT(20) PRIMARY KEY NOT NULL," +
                "name TEXT," +
                "address TEXT," +
                "lat TEXT," +
                "lng TEXT," +
                "email TEXT," +
                "phone TEXT," +
                "created_at TIMESTAMP," +
                "updated_at TIMESTAMP" +
                ")"

        val CREATE_SURVERIOR_TABLE = "CREATE TABLE $TABLE_SURVERIOR(" +
                "id_surverior INT(20) PRIMARY KEY NOT NULL," +
                "name TEXT" +
                ")"

        val CREATE_SURVERIOR_TASK_TABLE = "CREATE TABLE $TABLE_SURVERIOR_TASK (" +
                "id_surverior_task VARCHAR(200) PRIMARY KEY NOT NULL," +
                "id_surverior INT(20)," +
                "id_user INT(20)" +
                ")"

        val CREATE_ANSWER_TABLE = "CREATE TABLE $TABLE_ANSWER(" +
                "id_answer INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "question TEXT," +
                "descr TEXT," +
                "options TEXT," +
                "created_at TIMESTAMP," +
                "updated_at TIMESTAMP," +
                "id_user INT(20)," +
                "id_surverior_task VARCHAR(200)" +
                ")"

        p0?.execSQL(CREATE_QUESTION_TABLE)
        p0?.execSQL(CREATE_HOSPITAL_TABLE)
        p0?.execSQL(CREATE_SURVERIOR_TABLE)
        p0?.execSQL(CREATE_SURVERIOR_TASK_TABLE)
        p0?.execSQL(CREATE_ANSWER_TABLE)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertQuestion(idQuestion:Int?, question:String?, bab:String?, area:String?, standar:String?, ep:String?, idSurverior:Int?){

        val db = writableDatabase

        val INSERT = "INSERT OR REPLACE INTO $TABLE_QUESTION VALUES " +
                "($idQuestion,'$question','$bab','$area','$standar','$ep',datetime('now'),datetime('now'),$idSurverior)"
        db?.execSQL(INSERT)

    }

    fun loadBab() : ArrayList<Bab>{

        val arrayList = ArrayList<Bab>()

        val db = writableDatabase
        val LOAD_BAB = "SELECT bab FROM $TABLE_QUESTION GROUP BY bab ORDER BY id_question ASC"

        val cursor:Cursor? = db?.rawQuery(LOAD_BAB,null)

        if(cursor?.moveToFirst()!!){

            for(i in 0 until cursor?.count){
                arrayList.add(Bab(cursor?.getString(0)))
                cursor.moveToNext()
            }

        }

        return arrayList

    }

    fun loadArea(bab:String?) : ArrayList<Area>{

        val arrayList = ArrayList<Area>()

        val db = writableDatabase

        val LOAD_AREA = "SELECT area FROM $TABLE_QUESTION WHERE bab='$bab' GROUP BY area ORDER BY id_question ASC"

        val cursor:Cursor? = db.rawQuery(LOAD_AREA,null)

        if(cursor?.moveToFirst()!!){

            for(i in 0 until cursor?.count){

                arrayList.add(Area(cursor.getString(0)))
                cursor.moveToNext()

            }

        }

        return arrayList

    }


    fun loadQuestionByFilter(bab:String?, area:String?, idSurverior:Int) : ArrayList<Question>{

        val arrayList = ArrayList<Question>()

        val db = writableDatabase

        val LOAD = "SELECT * FROM $TABLE_QUESTION WHERE bab='$bab' AND area='$area' AND id_surverior=$idSurverior ORDER BY id_question ASC"

        val cursor:Cursor? = db.rawQuery(LOAD,null)

        if(cursor?.moveToFirst()!!){

            for(i in 0 until cursor?.count){

                arrayList.add(Question(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getInt(8)))
                cursor.moveToNext()

            }

        }

        return arrayList

    }

    fun loadQuestion() : ArrayList<Question>{

        val arrayList = ArrayList<Question>()

        val db = writableDatabase

        val LOAD = "SELECT * FROM $TABLE_QUESTION ORDER BY id_question ASC"

        val cursor:Cursor? = db.rawQuery(LOAD,null)

        if(cursor?.moveToFirst()!!){

            for(i in 0 until cursor?.count){

                arrayList.add(Question(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getInt(8)))
                cursor.moveToNext()

            }

        }

        return arrayList

    }

    fun clearQuestion(){

        val db = writableDatabase

        val DELETE = "DELETE FROM $TABLE_QUESTION"

        db.execSQL(DELETE)

    }

    fun insertHospital(idHospital:Int?, name:String?, address:String?, lat:String?, lng:String?, email:String?, phone:String?){

        val db = writableDatabase

        val INSERT = "INSERT OR REPLACE INTO $TABLE_HOSPITAL VALUES($idHospital,'$name','$address','$lat','$lng','$email','$phone',datetime('now'),datetime('now'))"

        db.execSQL(INSERT)

    }

    fun loadHospital() : ArrayList<Hospital>{

        var arrayList = ArrayList<Hospital>()

        val db = writableDatabase

        val LOAD = "SELECT * FROM $TABLE_HOSPITAL ORDER BY id_hospital ASC"

        val cursor:Cursor = db.rawQuery(LOAD,null)

        if(cursor.moveToFirst()){

            for(i in 0 until cursor.count){

                arrayList.add(Hospital(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8)))
                cursor.moveToNext()

            }

        }

        return arrayList

    }

    fun insertSurverior(idSurverior:Int?,name:String?){

        val db = writableDatabase

        val INSERT = "INSERT OR REPLACE INTO $TABLE_SURVERIOR VALUES($idSurverior,'$name')"

        db.execSQL(INSERT)

    }

    fun loadSurverior() : ArrayList<Surverior>{

        val arrayList = ArrayList<Surverior>()

        val db = writableDatabase

        val LOAD = "SELECT * FROM $TABLE_SURVERIOR ORDER BY id_surverior ASC"

        val cursor:Cursor = db.rawQuery(LOAD,null)

        if(cursor.moveToFirst()){

            for(i in 0 until cursor.count){

                arrayList.add(Surverior(cursor.getInt(0),
                        cursor.getString(1)))
                cursor.moveToNext()

            }

        }

        return arrayList

    }

    fun loadSurveriorNameById(idSurverior:Int?) : String?{

        var name:String? = null

        val db = writableDatabase

        val LOAD = "SELECT name FROM $TABLE_SURVERIOR WHERE id_surverior=$idSurverior"

        val cursor:Cursor = db.rawQuery(LOAD,null)

        if(cursor.moveToFirst()){

            name = cursor.getString(0)

        }

        return name

    }

    fun insertSurveriorTask(idSurveriorTask:String,idSurverior:Int,idUser:Int){

        val db = writableDatabase

        val INSERT = "INSERT INTO $TABLE_SURVERIOR_TASK VALUES('$idSurveriorTask',$idSurverior,$idUser)"

        db.execSQL(INSERT)

    }

    fun isSurveriorTaskExist(idSurveriorTask:String?) : Boolean{

        var getIdSurveriorTask:String? = null

        val db = writableDatabase

        val CHECK = "SELECT id_surverior_task FROM $TABLE_SURVERIOR_TASK WHERE id_surverior_task='$idSurveriorTask'"

        val cursor:Cursor = db.rawQuery(CHECK,null)

        if(cursor.moveToFirst()){

            for(i in 0 until cursor.count){
                getIdSurveriorTask = cursor.getString(0)
            }

        }

        return if(getIdSurveriorTask.equals(idSurveriorTask)){
            true
        }else{
            false
        }

    }


    fun loadSurveriorTask(idUser:Int) : ArrayList<SurveriorTask>{

        val arrayList = ArrayList<SurveriorTask>()

        val db = writableDatabase

        val LOAD = "SELECT * FROM $TABLE_SURVERIOR_TASK WHERE id_user=$idUser"

        val cursor:Cursor = db.rawQuery(LOAD,null)

        if(cursor.moveToFirst()){

            for(i in 0 until cursor.count){
                arrayList.add(SurveriorTask(cursor.getString(0),
                        cursor.getInt(1),
                        cursor.getInt(2)))
                cursor.moveToNext()
            }

        }

        return arrayList

    }

    fun loadSurveriorTaskById(idSurveriorTask:String) : ArrayList<SurveriorTask>{

        val arrayList = ArrayList<SurveriorTask>()

        val db = writableDatabase

        val LOAD = "SELECT * FROM $TABLE_SURVERIOR_TASK WHERE id_surverior_task='$idSurveriorTask'"

        val cursor:Cursor = db.rawQuery(LOAD,null)

        if(cursor.moveToFirst()){

            arrayList.add(SurveriorTask(cursor.getString(0),
                    cursor.getInt(1),
                    cursor.getInt(2)))

        }

        return arrayList

    }

    fun addAnswer(question:String?, descr:String?, options:String?, id_user:Int?, id_surverior_task:String?){

        val db = writableDatabase

        val ADD = "INSERT INTO $TABLE_ANSWER (question,descr,options,created_at,updated_at,id_user,id_surverior_task) VALUES(" +
                "'$question'," +
                "'$descr'," +
                "'$options'," +
                "datetime('now')," +
                "datetime('now')," +
                "$id_user," +
                "'$id_surverior_task'" +
                ")"

        db.execSQL(ADD)

    }

    fun loadAnswer() : ArrayList<Answer>{

        val arrayList = ArrayList<Answer>()

        val db = writableDatabase

        val LOAD = "SELECT *  FROM $TABLE_ANSWER GROUP BY id_surverior_task ORDER BY id_answer DESC"

        val cursor:Cursor = db.rawQuery(LOAD,null)

        if(cursor.moveToFirst()){

            for(i in 0 until cursor.count){

                arrayList.add(Answer(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getInt(6),
                        cursor.getString(7)))

                cursor.moveToNext()

            }

        }

        return arrayList

    }

    fun loadAnswerDetailByTask(idSurveriorTask: String?) : ArrayList<Answer>{

        val arrayList = ArrayList<Answer>()

        val db = writableDatabase

        val LOAD = "SELECT *  FROM $TABLE_ANSWER WHERE id_surverior_task='$idSurveriorTask' ORDER BY id_answer DESC"

        val cursor:Cursor = db.rawQuery(LOAD,null)

        if(cursor.moveToFirst()){

            for(i in 0 until cursor.count){

                arrayList.add(Answer(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getInt(6),
                        cursor.getString(7)))

                cursor.moveToNext()

            }

        }

        return arrayList

    }


}