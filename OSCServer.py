import argparse
import math
import requests
from osc import OSCServer

class SimpleServer(OSCServer):

  def handle(self, address, message, time):
      if message.address=='/flyto':
          print('Flying to %s'%message.args[0])

          if message.args[0]=="Bangkok":
              requests.get('http://localhost:5430/kml/flyto/100.501762/13.756331/58000')
          elif message.args[0]=="London":
              requests.get('http://localhost:5430/kml/flyto/-0.127758/51.507351/37000')
          elif message.args[0]=="Paris":
              requests.get('http://localhost:5430/kml/flyto/2.352413/48.856483/20000')
          elif message.args[0]=="Dubai":
              requests.get('http://localhost:5430/kml/flyto/55.270782/25.204849/107000')
          elif message.args[0]=="Tokyo":
              requests.get('http://localhost:5430/kml/flyto/139.691711/35.689487/62000')

      elif message.address!='/flyto':
          print("Error: Not a proper address")
      else:
          print("An error occured")

if __name__ == "__main__":
  parser = argparse.ArgumentParser()
  parser.add_argument("--ip",
      default="<enter your IP here>", help="The ip to listen on")
  parser.add_argument("--port",
      type=int, default=8140, help="The port to listen on")
  args = parser.parse_args()

  server = SimpleServer(args.ip, args.port)

  print("Serving on {}".format(server.server_address))
  server.serve_forever()
