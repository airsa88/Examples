
#Performing PySpark SQL operations on  National names csv data - in Jupyter notebook
# coding: utf-8

# In[2]:

sqlContext = SQLContext(sc)


# In[1]:

dframe = sqlContext.read.load('/home/NationalNames.csv',
                          format='com.databricks.spark.csv', 
                          header='true', 
                          inferSchema='true')


# In[2]:

from pyspark.sql.functions import * 


# In[10]:
# Query scenario 1 : Total number of birth registered in a year 
get_ipython().magic(u'time dframe.groupBy("year").sum("count").sort(sum("count").desc()).show()')


# In[12]:
# Query Scenario 2 : Total number of births registered in a year by gender
get_ipython().magic(u'time dframe.groupBy("gender","year").sum("count").show()')


# In[16]:
# Query Scenario 3 : Input a year and populate top 5 most popular names registered that year
get_ipython().magic(u'time dframe.filter(dframe[\'year\'] == 1902).sort(dframe[\'count\'].desc()).limit(5).select("name").show()')


# In[17]:
# Query Scenario 4 : Input a child name and populate total number of birth registrations throughout the dataset for that name 
get_ipython().magic(u'time dframe.filter(dframe[\'name\'] == "Mary").groupBy("name").sum(\'count\').show()')


# In[ ]:



