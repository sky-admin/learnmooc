import paramiko
import threading
import time

ip = '120.27.47.134'
user = 'root'
password = ''
jar = 'learnmooc-0.0.1-SNAPSHOT.jar'
home='/root/java/learnmooc'
current=home+"/current"
releases=home+"/releases"

def execute_cmds(ip, user, passwd, cmd):
    try:
        ssh = paramiko.SSHClient()
        ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        ssh.connect(ip,22,user,passwd,timeout=5)
        for m in cmd:
            print m
            stdin, stdout, stderr = ssh.exec_command(m)
#           stdin.write("Y")
            out = stdout.readlines()
            for o in out:
                print o,
        print '%s\tOK\n'%(ip)
        ssh.close()
    except :
        print '%s\tError\n'%(ip)


if __name__=='__main__':
    print 'Start deploying %s to server %s'%(jar, ip)

    now = time.strftime("%Y%m%d%H%M%S")
    cmd = [
        'echo Stop spring_learnmooc service... && service spring_learnmooc stop',
        'echo Use new jar... ' + \
        ' && mv ' + current + '/' + jar + ' ' + releases + '/' + now + '_' + jar ,
        'mv ' + home + '/' + jar + ' ' + current + '/' + jar,
        'echo Start spring_learnmooc service... && service spring_learnmooc start ' + \
        ' && echo All done.'
    ]
    a=threading.Thread(target=execute_cmds, args=(ip,user,password,cmd))
    a.start()