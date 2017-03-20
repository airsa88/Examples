
# Performing Spark SQL operations in Jupyter notebook - NYPDVehicleCollisions csv data.
# coding: utf-8

# In[2]:

sqlContext = SQLContext(sc)


# In[1]:

daframe1 = sqlContext.read.load('/home/NYPD_Motor_Vehicle_Collisions.csv',
                          format='com.databricks.spark.csv', 
                          header='true', 
                          inferSchema='true')


# In[2]:

daframe1.createOrReplaceTempView("NYPDVehicleCollisions")


# In[3]:
#Preprocessing CSV

daframe2 = spark.sql("""select DATE,BOROUGH,`NUMBER OF PERSONS INJURED`,`NUMBER OF PEDESTRIANS INJURED`,`NUMBER OF CYCLIST INJURED`,
`NUMBER OF MOTORIST INJURED`,`NUMBER OF PERSONS KILLED`,`NUMBER OF PEDESTRIANS KILLED`,`NUMBER OF CYCLIST KILLED`,
`NUMBER OF MOTORIST KILLED`,`UNIQUE KEY` from NYPDVehicleCollisions""")


# In[4]:

daframe2.createOrReplaceTempView("NYPDVehicleCollisions2")


# In[5]:
#Query scenario 1 : Capture total injuries and fatalities associated with each motor collision record(identified by a unique incident key) 

get_ipython().run_cell_magic(u'time', u'', u'daframe3 = spark.sql("""select `UNIQUE KEY`,cast(sum(`NUMBER OF PERSONS INJURED` + `NUMBER OF PEDESTRIANS INJURED` + `NUMBER OF CYCLIST INJURED` + `NUMBER OF MOTORIST INJURED`) as decimal (8,0)) as `Total Injuries`,cast(sum(`NUMBER OF PERSONS KILLED` + `NUMBER OF PEDESTRIANS KILLED` + `NUMBER OF CYCLIST KILLED` + `NUMBER OF MOTORIST KILLED`) as decimal (8,0)) as `Total Fatalities` from NYPDVehicleCollisions2 GROUP BY `UNIQUE KEY`""").show(30,False)')


# In[6]:
# Query scenario 2 : Capture total incident counts in a year (grouped by year) 
get_ipython().run_cell_magic(u'time', u'', u'daframe4 = spark.sql("""select YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))) AS Year,count(`UNIQUE KEY`) AS `Total Incidents` from NYPDVehicleCollisions2 where YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))) not in(\'null\') GROUP BY YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))) ORDER BY count(`UNIQUE KEY`) DESC""").show()')


# In[19]:
#Query scenario 3 : Capture total injuries(can be sum of injuries and fatalities) grouped by year and quarter 
get_ipython().run_cell_magic(u'time', u'', u'daframe5 = spark.sql("""select YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))) AS Year,QUARTER(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))) AS Quarter,cast(sum(`NUMBER OF PERSONS INJURED` + `NUMBER OF PEDESTRIANS INJURED` + `NUMBER OF CYCLIST INJURED` + `NUMBER OF MOTORIST INJURED`+ `NUMBER OF PERSONS KILLED` + `NUMBER OF PEDESTRIANS KILLED` + `NUMBER OF CYCLIST KILLED` + `NUMBER OF MOTORIST KILLED`) as decimal (8,0)) as `Total Injuries` from NYPDVehicleCollisions2\nwhere YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))) not in(\'null\')\nGROUP BY YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))),\nQUARTER(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP)))""").show() ')


# In[20]:
# Query Scenario 4 : Capture total injuries(sum of injuries and fatalities) and incident count grouped by Borough, year and month
get_ipython().run_cell_magic(u'time', u'', u'daframe6 = spark.sql("""select BOROUGH,YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))) AS Year,MONTH(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))) AS Month,cast(sum(`NUMBER OF PERSONS INJURED` + `NUMBER OF PEDESTRIANS INJURED` + `NUMBER OF CYCLIST INJURED` + `NUMBER OF MOTORIST INJURED`+ `NUMBER OF PERSONS KILLED` + `NUMBER OF PEDESTRIANS KILLED` + `NUMBER OF CYCLIST KILLED` + `NUMBER OF MOTORIST KILLED`) as decimal (8,0)) as `Total Injuries`,count(`UNIQUE KEY`) as `Incident Count` from NYPDVehicleCollisions2 where BOROUGH not in(\'null\') GROUP BY BOROUGH,YEAR(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP))),MONTH(TO_DATE(CAST(UNIX_TIMESTAMP(date, \'MM/dd/yyyy\') AS TIMESTAMP)))""").show(30,False)')


# In[ ]:



