#!/bin/bash

usage() {
	echo "Copy file from local computer to remote host using SFTP and identity key"
	echo "Usage: $0 <local_file> <identity_key> <username@hostname> <remote_file>"	
}

echo "The $0 starting..."

if [ $# -ne 4 ]; then
	usage
	exit 1
fi

TEST=false
TEST_SSH=false
PICTORIAL_SERVICE="pictorial.service"

local_file=$1
identity_key=$2
user_host=$3
remote_file=$4
remote_file_tmp="$remote_file.tmp"


#----------------------------
# 1. File transfer with temporary file name
#----------------------------
echo "1. Transfering file $local_file..."

cmd="scp -i $identity_key $local_file $user_host:$remote_file_tmp"
echo "CMD: $cmd"

if [ $TEST != true ]; then
	echo "Transfer file"
	eval $cmd
	if [ $? != 0 ]; then
		echo "Error during file transfer. Exiting..."
		exit 1;
	fi
else
	echo "Testing - skipping actual file transfer"
fi

#----------------------------
# 2. Create temporary exec file
#----------------------------
exec_file="exec.sh"
echo "#!/bin/bash" > $exec_file
if [ $? != 0 ]; then
	echo "Error during exec file creation. Exiting..."
	exit 1;
fi

#----------------------------
# 2.2. Stop pictorial service
#----------------------------
echo "sudo systemctl stop $PICTORIAL_SERVICE" >> $exec_file

#----------------------------
# 2.3. Replace JAR file
#----------------------------
echo "sudo chown pictorial:pictorial $remote_file_tmp" >> $exec_file
echo "sudo mv $remote_file_tmp $remote_file" >> $exec_file
echo "sudo chmod 775 $remote_file" >> $exec_file

#----------------------------
# 2.4. Start pictorial server
#----------------------------
echo "sudo systemctl stop $PICTORIAL_SERVICE" >> $exec_file

#----------------------------
# 3. Make exec file runnable
#----------------------------
chmod u+x $exec_file

#----------------------------
# 4. Run exec file
#----------------------------
if [ $TEST_SSH != true ]; then
	ssh_cmd="ssh -i $identity_key $user_host 'bash -e' < $exec_file"
	eval "pwd"
	echo "Exec file execution ($ssh_cmd)"
	eval $ssh_cmd	
	if [ $? != 0 ]; then
		echo "Error during exec file execution. Exiting..."
		exit 1
	fi
else
	echo "Testing - skipping actual exec file execution"
fi

#----------------------------
# 5. Remove exec file
#----------------------------
if [ $TEST != true ]; then
	echo "Exec file removal"
	rm $exec_file
	if [ $? != 0 ]; then
		echo "Error during exec file removal."
	fi
else
	echo "Testing - skipping actual exec file removal"
fi

