from flask import render_template
import os 

def routes(app):
    
    ## USER ROUTES
    @app.route("/printplus")
    def userIndex() -> str:
        return "Visão do usuario"

    ## ADMIN ROUTES
    @app.route("/admin/printplus")
    def adminIndex() -> str:
        

        return "Visão do admin"