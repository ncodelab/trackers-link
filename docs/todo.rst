=================
Development tasks
=================

Bitbucket
---------
- Load list of issues
- Create new issue
- Modify an issue (description, status, assignee)
- Add comment to an issue

Youtrack
--------
- Load list of tasks
- Create new task
- Modify task (description, status, assignee)
- Add comment to an issue

Link
----
- Load new tasks Bitbucket -> Youtrack
- Load new issues Youtrack -> Bitbucket
- Update issues Youtrack -> Bitbucket
- Update issues Bitbucket -> Youtrack
- Add new comments Youtrack -> Bitbucket
- Add new comments Bitbucket -> Youtrack

Implementation details
----------------------
- Bitbucket project field ?? or retrieve from one repo to one project only?
- Bitbucket issue number field
- Compare all comments (maybe store some ids, to update them both ways later)
- Try to implement w/o middleware db storage
