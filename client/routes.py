from flask import render_template
import os 

def routes(app):
    
    ## USER ROUTES
    @app.route("/printplus")
    def userIndex() -> str:
        return "Visão do usuario"